package com.wmeimob.yzfs.smsUtil;
import java.util.Map;
import java.util.Random;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SmsUtils {
	
    public static SingleSendSmsResponse sampleSms(String templateCode,Map<String, Object> map,String recNum) {   
    	SingleSendSmsResponse httpResponse = null;
        try {
        	ObjectMapper mapper = new ObjectMapper();
            // 设置超时时间-可自行调整  
            System.setProperty("sun.net.client.defaultConnectTimeout", "20000");  
            System.setProperty("sun.net.client.defaultReadTimeout", "20000");  
            // 初始化ascClient需要的几个参数  
            final String product = "TITA时尚";// 短信API产品名称  
            final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名  
            // 替换成你的AK  
            final String accessKeyId = "LTAIKQ2N7TXPFDeZ";// 你的accessKeyId,参考本文档步骤2  
            final String accessKeySecret = "DdQp2Jz24zeZslbZ8Wm2DSsmTVT1BY";// 你的accessKeySecret，参考本文档步骤2  
            // 初始化ascClient,暂时不支持多region  
            IClientProfile profile = DefaultProfile.getProfile("cn-shanghai",  
                    accessKeyId, accessKeySecret);  
            DefaultProfile.addEndpoint("cn-shanghai", "cn-shanghai", product,  
                    domain);  
            IAcsClient acsClient = new DefaultAcsClient(profile);  
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName("TITA时尚");
            request.setTemplateCode(templateCode);
            request.setParamString(mapper.writeValueAsString(map));
            request.setRecNum(recNum);
            httpResponse = acsClient.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return httpResponse;
    }
    
    
    /** 
     * 产生随机的六位数 
     * @return 
     */  
    public static String getCode(){  
        Random rad=new Random();  
        String result  = rad.nextInt(1000000) +"";  
        if(result.length()!=6){  
            return getCode();  
        }  
        return result;  
    } 

}
