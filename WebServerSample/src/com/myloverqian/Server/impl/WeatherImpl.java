package com.myloverqian.Server.impl;

import com.myloverqian.Server.Weather;

import javax.jws.WebService;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/1/27
 */
@WebService
public class WeatherImpl implements Weather {

    @Override
    public String queryWeather(String location) {
        System.out.println("from client:" + location);
        String result = "晴";
        System.out.println("to client:" + result);
        return result;
    }
}
