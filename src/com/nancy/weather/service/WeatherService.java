package com.nancy.weather.service;

import android.util.Xml;
import com.nancy.weather.domain.WeatherInfo;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nancy on 15-10-10.
 */
public class WeatherService {

    public static List<WeatherInfo> getWeatherInfos( InputStream is ){

        List<WeatherInfo> weatherInfos = null;
        WeatherInfo weatherInfo = null;
        //创建xml pull解析器
        XmlPullParser parser = Xml.newPullParser();
        try{
            //初始化pull xml解析
            parser.setInput(is, "utf-8");
            int type = parser.getEventType();
            while( type != XmlPullParser.END_DOCUMENT){
                switch( type ){
                    case XmlPullParser.START_TAG:
                        if( "infos".equals( parser.getName() ) ){
                            weatherInfos = new ArrayList<WeatherInfo>();
                        }else if( "city".equals(parser.getName()) ){
                            weatherInfo = new WeatherInfo();
                            weatherInfo.setId( Integer.parseInt(parser.getAttributeValue(0))  );
                        }else if("temp".equals(parser.getName())){
                            weatherInfo.setTemp( parser.nextText() );
                        }else if("weather".equals(parser.getName())){
                            weatherInfo.setWeather(parser.nextText());
                        }else if("wind".equals(parser.getName())){
                            weatherInfo.setWind(parser.nextText());
                        }else if("name".equals(parser.getName())){
                            weatherInfo.setName(parser.nextText());
                        }else if("pm".equals(parser.getName())){
                            weatherInfo.setPm(parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("city".equals(parser.getName())){
                            weatherInfos.add(weatherInfo);
                            weatherInfo = null;
                        }
                        break;
                }
                type = parser.next();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return weatherInfos;

    }
}
