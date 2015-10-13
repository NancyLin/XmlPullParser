package com.nancy.weather.domain;

/**
 * Created by nancy on 15-10-10.
 */
public class WeatherInfo {

    private int id; //城市id
    private String temp; //温度
    private String weather; //天气
    private String wind; //风向
    private String name; //名称
    private String pm; //pm2.5

    @Override
    public String toString() {
        return name+"天气信息{" +
                "id=" + id +
                ", 气温='" + temp + '\'' +
                ", 天气='" + weather + '\'' +
                ", 风向='" + wind + '\'' +
                ", name='" + name + '\'' +
                ", pm2.5='" + pm + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }
}
