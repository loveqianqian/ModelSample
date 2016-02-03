package com.myloverqian.Server.impl;

import com.myloverqian.Server.Weather;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/1/27
 */
@WebService
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class WeatherImpl implements Weather {

    @Override
    public String queryWeather(String location) {
        System.out.println("from client:" + location);
        String result = "晴";
        System.out.println("to client:" + result);
        return result;
    }
}
