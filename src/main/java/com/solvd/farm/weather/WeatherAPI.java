package com.solvd.farm.weather;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WeatherAPI {
    public static final Logger LOGGER = LogManager.getLogger(WeatherAPI.class);

    public static void main(String[] args) {
       Weather weather=Weather.WEATHER;
       String lat="6.265643";
       String lon="-75.574925";
       weather.getWeather(lat,lon);
    }


}