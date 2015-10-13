package com.nancy.weather;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.nancy.weather.domain.WeatherInfo;
import com.nancy.weather.service.WeatherService;

import java.util.List;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView tvText = (TextView) this.findViewById(R.id.tv);
        //使用类加载器加载xml文件
        List<WeatherInfo> weatherInfos = WeatherService.getWeatherInfos(MainActivity.class.getClassLoader()
                .getResourceAsStream("weather.xml"));

        String showWeatherStr = "";
        for(WeatherInfo info: weatherInfos){
            showWeatherStr += info.toString() + "\n";
        }

        tvText.setText(showWeatherStr);

    }
}
