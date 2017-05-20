package com.concentration.domain.service.impl;

import com.concentration.bean.UserBean;
import com.concentration.domain.dao.LoginMapper;
import com.concentration.domain.service.ILoginService;
import com.concentration.util.AESHelperUtil;
import com.concentration.util.JsonResult;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 2017/4/17.
 */
@Repository
public class LoginServiceImpl implements ILoginService {
    @Resource
    LoginMapper loginMapper;

    /**
     * 注册
     *
     * @param user_name
     * @param user_password
     * @param user_code
     * @param user_phone
     * @return
     */
    public JsonResult register(String user_name, String user_password, String user_code, String user_phone) {
        JsonResult jsonResult = new JsonResult();
        UserBean userExist = isUserExist(user_phone);

        if (userExist == null) {

            int i = addUser(user_name, user_password, user_code, user_phone);
            if (i > 0) {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(1);
                jsonResult.setMessage("注册成功,请登录~~");
            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(0);
                jsonResult.setMessage("注册失败~~");
            }

           /* String result = requestData("https://webapi.sms.mob.com/sms/verify",
                    "appkey=1b64f77b855de&phone=" +  AESHelperUtil.decrypt(user_phone)  + "&zone=86&&code=" + user_code);
            if (result.contains("200")) {



            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(0);
                jsonResult.setMessage("验证码错误~~");
            }*/

        } else {
            jsonResult.setData(new ArrayList());
            jsonResult.setCode(0);
            jsonResult.setMessage("手机号已存在~~");
        }
        return jsonResult;
    }

    /**
     * 登录
     *
     * @param user_phone
     * @param user_password
     * @return
     */
    public JsonResult login(String user_phone, String user_password) {
        JsonResult jsonResult = new JsonResult();

        if (user_phone != null && user_password != null) {
            UserBean userBean = loginMapper.userExists(user_phone, user_password);
            if (userBean != null) {
                List<UserBean> list = new ArrayList<UserBean>();
                list.add(userBean);
                jsonResult.setData(list);
                jsonResult.setCode(1);
                jsonResult.setMessage("登录成功~~");
            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(0);
                jsonResult.setMessage("用户不存在或密码错误~~");
            }
        } else {
            jsonResult.setData(new ArrayList());
            jsonResult.setCode(0);
            jsonResult.setMessage("用户不存在或密码错误~~");
        }

        return jsonResult;
    }

    /**
     * 找回密码
     *
     * @param user_phone
     * @param user_password
     * @param user_code
     * @return
     */
    public JsonResult retrievePassword(String user_phone, String user_password, String user_code) {
        JsonResult jsonResult = new JsonResult();
        if (user_phone != null && user_password != null && user_code != null) {
            UserBean userExist = isUserExist(user_phone);
            if (userExist != null) {

                int i = loginMapper.userFindPassWord(user_phone, user_password, user_code);
                if (i > 0) {
                    jsonResult.setData(new ArrayList<UserBean>());
                    jsonResult.setCode(1);
                    jsonResult.setMessage("修改成功,请登录~~");
                } else {
                    jsonResult.setData(new ArrayList<UserBean>());
                    jsonResult.setCode(0);
                    jsonResult.setMessage("修改成功,请登录~~");
                }

                /*String result = requestData("https://webapi.sms.mob.com/sms/verify",
                        "appkey=1b64f77b855de&phone=" + AESHelperUtil.decrypt(user_phone) + "&zone=86&&code=" + user_code);
                if (result.equals("200")) {

                } else {
                    jsonResult.setData(new ArrayList());
                    jsonResult.setCode(0);
                    jsonResult.setMessage("验证码错误~~");
                }*/

            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(0);
                jsonResult.setMessage("用户不存在~~");
            }
        } else {
            jsonResult.setData(new ArrayList());
            jsonResult.setCode(0);
            jsonResult.setMessage("用户不存在或参数异常~~");
        }
        return jsonResult;
    }

    /**
     * 用户名是否存在
     *
     * @param user_phone
     * @return
     */
    public UserBean isUserExist(String user_phone) {
        if (user_phone != null) {
            return loginMapper.isUserExist(user_phone);
        } else {
            return null;
        }
    }

    /**
     * 添加用户
     *
     * @param user_name
     * @param user_password
     * @param user_code
     * @param user_phone
     * @return
     */
    public int addUser(String user_name, String user_password, String user_code, String user_phone) {
        if (user_phone != null && user_name != null
                && user_password != null
                && user_code != null) {

            return loginMapper.addUser(user_name, user_password, user_code, user_phone, "");
        } else {
            return 0;
        }
    }

    /**
     * share短信验证码 发起https 请求
     *
     * @param address
     * @return
     */
    public static String requestData(String address, String params) {

        HttpURLConnection conn = null;
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());

            //ip host verify
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    return urlHostName.equals(session.getPeerHost());
                }
            };

            //set ip host verify
            HttpsURLConnection.setDefaultHostnameVerifier(hv);

            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            URL url = new URL(address);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");// POST
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            // set params ;post params
            if (params != null) {
                conn.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                out.write(params.getBytes(Charset.forName("UTF-8")));
                out.flush();
                out.close();
            }
            conn.connect();
            //get result
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String result = parsRtn(conn.getInputStream());
                return result;
            } else {
                System.out.println(conn.getResponseCode() + " " + conn.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.disconnect();
        }
        return null;
    }

    /**
     * 这个是抽取出来的方法，返回请求的参数
     *
     * @param in
     * @return
     */
    public static String parsRtn(InputStream in) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte[] buffer = new byte[1024];

        try {
            while ((len = in.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            in.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(baos.toByteArray());
    }

}
