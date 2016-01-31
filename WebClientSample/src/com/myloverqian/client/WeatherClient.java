package com.myloverqian.client;

import com.myloverqian.server.impl.WeatherImpl;
import com.myloverqian.server.impl.WeatherImplService;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/1/28
 */
public class WeatherClient {
    public static void main(String[] args) {
        WeatherImplService service = new WeatherImplService();
        /** portType类型 */
        WeatherImpl weatherImplPort = service.getWeatherImplPort();
        String result = weatherImplPort.queryWeather("TianJin");
        System.out.println("from server:" + result);
    }
}
