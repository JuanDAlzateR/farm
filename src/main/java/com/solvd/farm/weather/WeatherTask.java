package com.solvd.farm.weather;

import com.solvd.farm.interfaces.ITask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WeatherTask implements ITask {
    public static final Logger LOGGER = LogManager.getLogger(WeatherTask.class);
    private int seconds;
    private volatile boolean keepRunning = true; // Use a flag for controlled shutdown
    private String latitude = "6.265643";
    private String longitude = "-75.574925";
    private boolean fullWeatherInfo = true;

    public WeatherTask(int seconds) {
        this.seconds = seconds;
    }

    public WeatherTask(String latitude, String longitude, int seconds) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.seconds = seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setFullWeatherInfo(boolean fullWeatherInfo) {
        this.fullWeatherInfo = fullWeatherInfo;
    }

    // Method to stop the thread
    @Override
    public void stop() {
        this.keepRunning = false;
    }

    @Override
    public void run() {
        Weather weather = Weather.WEATHER;

        while (keepRunning) {
            try {
                LOGGER.info("");
                LOGGER.info("-- Weather Information (Printed every " + seconds + "s) --");
                weather.getWeather(latitude, longitude, fullWeatherInfo);
                //LOGGER.info("weather info...");
                LOGGER.info("-------------------------\n");

                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                // If interrupted, restore the flag and exit the loop
                Thread.currentThread().interrupt();
                keepRunning = false;
                LOGGER.warn("Weather thread was interrupted and is shutting down.");
            }
        }
    }
}