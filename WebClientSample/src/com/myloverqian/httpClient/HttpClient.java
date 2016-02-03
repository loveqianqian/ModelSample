package com.myloverqian.httpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:模拟http请求，向webService发送soap协议</p>
 *
 * @author:diaozhiwei
 * @data:2016/1/31
 */
public class HttpClient {

    /**
     * @return
     * <?xml version="1.0" ?>
     * <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
     * <S:Body>
     * <ns2:queryWeatherResponse xmlns:ns2="http://impl.Server.myloverqian.com/">
     * <return>晴</return>
     * </ns2:queryWeatherResponse>
     * </S:Body>
     * </S:Envelope>
     *
     */
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        String result = "";
        try {
            URL url = new URL("http://192.168.40.1:8081/weather");//开启http链接
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");//设置post请求
            //Content-Type: text/xml; charset=utf-8
            httpURLConnection.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
            httpURLConnection.setDoInput(true);//设置请求和相应
            httpURLConnection.setDoOutput(true);
            String requestString = httpRequest("北京");
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(requestString.getBytes());//发送soap协议
            inputStream = httpURLConnection.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len = -1;
            byte[] bytes = new byte[1024];
            //将inputStream的内容写到byteArrayOutputStream
            while ((len = inputStream.read(bytes, 0, 1024)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            result = byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }

    private static String httpRequest(String args) {
        String result = "<?xml version=\"1.0\" ?><S:Envelope xmlns:S=\"http://schemas.xmlsoap" +
                ".org/soap/envelope/\"><S:Body><ns2:queryWeather xmlns:ns2=\"http://impl.Server.myloverqian" +
                ".com/\"><arg0>" + args + "</arg0></ns2:queryWeather></S:Body></S:Envelope>";
        return result;
    }
}
