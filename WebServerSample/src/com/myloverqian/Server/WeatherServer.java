package com.myloverqian.Server;

import com.myloverqian.Server.impl.WeatherImpl;

import javax.xml.ws.Endpoint;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/1/27
 */
public class WeatherServer {
    public static void main(String[] args) {
        Endpoint.publish("http://192.168.40.1:8081/weather", new WeatherImpl());
    }
}
