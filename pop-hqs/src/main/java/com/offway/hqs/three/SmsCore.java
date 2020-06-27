package com.offway.hqs.three;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

/**
 * @Author LXM
 * @Date 2020/6/21 0021
 */
public class SmsCore {
    private static String key = " ";
    //AKIDtXv2t4bbxIQHxTnkTxTpupfE3cyD8zWn
    private static String keysecret = " ";
    //LQGp8BOMywhJo6NgH3Z4NbihUHnAzas0

    //发送短信验证码
    public static boolean sendRCode(String phone, int code) {


        Credential cred = new Credential(key, keysecret);

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("sms.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        SmsClient client = new SmsClient(cred, "ap-beijing", clientProfile);

        String params = "{\"PhoneNumberSet\":[\"+86" + phone + "\"],\"TemplateID\":\"639287\",\"Sign\":\"IT社区1024\",\"TemplateParamSet\":[\"" + code + "\",\"5\"],\"SmsSdkAppid\":\"1400386152\"}";

        try {
            SendSmsRequest req = SendSmsRequest.fromJsonString(params, SendSmsRequest.class);
            SendSmsResponse resp = client.SendSms(req);
            return true;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
            return false;
        }
    }
}
