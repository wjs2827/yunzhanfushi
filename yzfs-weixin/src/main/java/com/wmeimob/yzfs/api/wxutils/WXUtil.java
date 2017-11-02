package com.wmeimob.yzfs.api.wxutils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.apache.axis.utils.XMLUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import com.wmeimob.wechat.model.pay.WxPaySign;
import com.wmeimob.yzfs.weixin.WeChatUtil;

@SuppressWarnings("deprecation")
public class WXUtil {
	private static DefaultHttpClient httpclient = new DefaultHttpClient();
    public  static String APP_ID = WeChatUtil.APP_ID;
    private static String MCH_ID = WeChatUtil.MCHID;
    public  static String MACH_KEY = WeChatUtil.MCHKEY;
	
    
	/**
	 * 充值签名参数拼接
	 * @param payAmount
	 * @return
	 */
	private static String getXmlStringByorder(String contextPath,String openId,String snCode,BigDecimal payAmount,String notify_url) {
		DecimalFormat  df = new DecimalFormat ("#");
		String sumAmount =df.format((Double.parseDouble(payAmount.toString()))*100);
		StringBuilder xmlString = new StringBuilder();
		String nonce_str=UUID.randomUUID().toString().replace("-","");
		//签名
		String paramString = "appid="+APP_ID+"&body=wxpay&mch_id="+MCH_ID+"&nonce_str="+nonce_str+"&notify_url="+notify_url+
				"&openid="+openId+"&out_trade_no="+snCode+"&total_fee="+sumAmount+"&trade_type=JSAPI&key="+MACH_KEY;
		String sign = getMD5Sign(paramString);
		xmlString.append("<xml>");
		xmlString.append("<appid>"+APP_ID+"</appid>");
		xmlString.append("<body>wxpay</body>");
		xmlString.append("<mch_id>"+MCH_ID+"</mch_id>");
		xmlString.append("<nonce_str>"+nonce_str+"</nonce_str>");
		xmlString.append("<notify_url>"+notify_url+"</notify_url>");
		xmlString.append("<openid>"+openId+"</openid>");
		xmlString.append("<out_trade_no>"+snCode+"</out_trade_no>");
		xmlString.append("<total_fee>"+sumAmount+"</total_fee>");
		xmlString.append("<trade_type>JSAPI</trade_type>");
		xmlString.append("<sign>"+sign+"</sign>");
		xmlString.append("</xml>");
		return xmlString.toString();
	}

	/**
	 * 计算签名
	 * @param packageString
	 * @return
	 */
	public static String getMD5Sign(String packageString) {
		String sign = MD5Util.encrypt(packageString).toUpperCase();
		return sign;
	}
	
    /**
     * 微信创建支付订单参数
     *
     * @param xml
     * @return
     */
    public static WxPaySign wxCreateOrder(Map<String, Object> map) {
        WxPaySign wxPay = null;
        try {
            if ("SUCCESS".equals(map.get("return_code")) && "SUCCESS".equals(map.get("result_code"))) {
            	String prepay_id = map.get("prepay_id").toString();
                wxPay = new WxPaySign();
                wxPay.setAppId(APP_ID);
                wxPay.setNonceStr(UUID.randomUUID().toString().replace("-",""));
                wxPay.setPackage2("prepay_id=" + prepay_id);
                wxPay.setSignType("MD5");
                String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
                wxPay.setTimeStamp(timeStamp);
                wxPay.setPaySign(WXMD5signUtil.wxPaySign(wxPay, MACH_KEY));
            }
        } catch (Exception e) {
            return null;
        }
        return wxPay;
    }
    
    /**
     * 微信创建支付订单参数
     *
     * @param xml
     * @return
     */
    public static TreeMap<String, Object> wxCreateOrderTwo(Map<String, Object> map) {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        try {
            if ("SUCCESS".equals(map.get("return_code")) && "SUCCESS".equals(map.get("result_code"))) {
            	String prepay_id = map.get("prepay_id").toString();
                String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
    		    treeMap.put("appId", APP_ID);
    		    treeMap.put("timeStamp", timeStamp);
    		    treeMap.put("nonceStr", UUID.randomUUID().toString().replace("-",""));
    		    treeMap.put("package","prepay_id=" + prepay_id);
    		    treeMap.put("signType", "MD5");
    		    String paySign = Signature.getInstance(MACH_KEY).getSign(treeMap);
    		    treeMap.put("paySign", paySign);
            }
        } catch (Exception e) {
            return null;
        }
        return treeMap;
    }
    
    /**
     * 验证微信支付签名
     * @param xml
     * @return
     */
    public static String checkWXSign(Map<String, String> map) {
    	String sign=null;
        TreeMap<String, Object> treeMap = new TreeMap<>();
        try {
            if ("SUCCESS".equals(map.get("return_code")) && "SUCCESS".equals(map.get("result_code"))) {
            	String prepay_id = map.get("prepay_id").toString();
                String timeStamp =map.get("time_end").toString();
                String nonceStr =map.get("nonce_str").toString();
    		    treeMap.put("appId", APP_ID);
    		    treeMap.put("timeStamp", timeStamp);
    		    treeMap.put("nonceStr", nonceStr);
    		    treeMap.put("package","prepay_id=" + prepay_id);
    		    treeMap.put("signType", "MD5");
    		    sign = Signature.getInstance(MACH_KEY).getSign(treeMap);
            }
        } catch (Exception e) {
            return null;
        }
        return sign;
    }


	public static String getUnifiedorderXml(HttpServletRequest request,String openId,String snCode, BigDecimal payAmount,String notify_url) throws Exception {
		//拼xml
		String contextPath = request.getContextPath();
		String xmlString = getXmlStringByorder(contextPath,openId,snCode,payAmount,notify_url);
		StringEntity se = new StringEntity(xmlString,"UTF-8");
		se.setContentType("application/json; charset=UTF-8");
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		HttpPost hp = new HttpPost(url);
		hp.setEntity(se);
		HttpResponse hr = httpclient.execute(hp);
		HttpEntity he = hr.getEntity();
		if(he!=null){
			BufferedReader br = new BufferedReader(new InputStreamReader(he.getContent(),"UTF-8"));
			String line = null;
			StringBuffer content = new StringBuffer();
			while((line =  br.readLine())!=null){
				content.append(line+"\n");
			}
			return content.toString();
		}
		return null;
	}
	
	
	
	

	
}
