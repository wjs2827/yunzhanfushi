package com.wmeimob.yzfs.api.smsUtil;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.wmeimob.yzfs.smsUtil.AliyunSmsConfig;
import java.io.UnsupportedEncodingException;



/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 * <p>
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 */
public class AliyunSmsUtil {

    public static SendSmsResponse sendSms(String tel, String content) throws ClientException, UnsupportedEncodingException {

        //初始化acsClient,暂不支持region化
//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", property.getString("ALIYUN_SMS_ACCESS_KEY"), property.getString("ALIYUN_SMS_ACCESS_SECRET"));
//        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//        IAcsClient acsClient = new DefaultAcsClient(profile);

        

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//        request.setOutId("yourOutId");

        try {
			//可自助调整超时时间
			//        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
			//        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",AliyunSmsConfig.getValue("ALIYUN_SMS_ACCESS_KEY"), AliyunSmsConfig.getValue("ALIYUN_SMS_ACCESS_SECRET"));
            IAcsClient acsClient = new DefaultAcsClient(profile);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
			//组装请求对象-具体描述见控制台-文档部分内容
			SendSmsRequest request = new SendSmsRequest();
			//必填:待发送手机号
			request.setPhoneNumbers(tel);
			//必填:短信签名-可在短信控制台中找到
			request.setSignName(AliyunSmsConfig.getValue("ALIYUN_SMS_SIGN"));
			//必填:短信模板-可在短信控制台中找到
			request.setTemplateCode(AliyunSmsConfig.getValue("ALIYUN_SMS_VALID_CODE_TEMPLATE"));
			//可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
			request.setTemplateParam("{\"code\":\"" + content + "\"}");
			//hint 此处可能会抛出异常，注意catch
			SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
			return sendSmsResponse;
		} catch (Exception e) {
			return null;
		}
    }


}
