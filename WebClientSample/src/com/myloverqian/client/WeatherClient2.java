package com.myloverqian.client;

import com.myloverqian.server.impl.WeatherImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/1/28
 */
public class WeatherClient2 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://192.168.40.1:1808/weather");
        QName qName = new QName("http://impl.Server.myloverqian.com/", "WeatherImplService");
        Service service = Service.create(url, qName);
        WeatherImpl port = service.getPort(WeatherImpl.class);
        String result = port.queryWeather("天津");
        System.out.println(result);
    }
}
