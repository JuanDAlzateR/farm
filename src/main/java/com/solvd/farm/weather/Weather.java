package com.solvd.farm.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum Weather {
    WEATHER;

    public static final Logger LOGGER = LogManager.getLogger(Weather.class);

    public void getWeather(String lat, String lon, boolean fullInfo) {
        try {
            HttpResponse<String> response = getHttpResponse(lat, lon);
            String jsonString = "";
            if (response.statusCode() == 200) {
                jsonString = response.body();

            } else {
                throw new RuntimeException();
            }
            if (fullInfo) {
                getWeatherInfo(jsonString);
            } else {
                getCurrentWeather(jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getWeather(String lat, String lon) {
        getWeather(lat, lon, true);
    }

    private static String accessKey() {

        File file = new File("config\\weatherapi\\key.txt");
        String content = "";
        try {
            content = FileUtils.readFileToString(file, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return content;
        }

    }

    private static HttpResponse<String> getHttpResponse(String lat, String lon) {

        HttpClient client = HttpClient.newHttpClient();

        String key = accessKey();//access token for meteosource
        String urlTemplate = "https://www.meteosource.com/api/v1/free/point?lat=%s&lon=%s&sections=current%%2Chourly&language=en&units=metric&key=%s";
        //String url="https://www.meteosource.com/api/v1/free/point?lat="+lat+"&lon="+lon+"&sections=current%2Chourly&language=en&units=metric&key="+key;
        String url = String.format(urlTemplate, lat, lon, key);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOGGER.debug("HTTP response code: " + response.statusCode());

        return response;
    }

    private static void getWeatherInfo(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String lat = rootNode.get("lat").asText();
        String lon = rootNode.get("lon").asText();
        int elevation = rootNode.get("elevation").asInt();
        String timezone = rootNode.get("timezone").asText();
        LOGGER.info("BASIC INFO:  timezone: " + timezone + " lat: " + lat + " lon: " + lon + " elevation : " + elevation + "m");

        String summary = rootNode.path("current").get("summary").asText();
        double temperature = rootNode.path("current").get("temperature").asDouble();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeNow = dateTime.format(formatter);
        LOGGER.info("CURRENT WEATHER:  time: " + timeNow + " summary: " + summary + "  temperature: " + temperature + " °C");

        JsonNode hourlyData = rootNode.path("hourly").path("data");
        int minutes = dateTime.getMinute();
        int n = (minutes < 45) ? 1 : 2;
        JsonNode hourNode = hourlyData.get(2); //needs to implement better logic to access desired hour prediction

        String date = hourNode.get("date").asText();
        String time = date.split("T")[1];
        String summ = hourNode.get("summary").asText();
        double temp = hourNode.get("temperature").asDouble();
        LOGGER.info("PREDICTION:  time: " + time + " summary: " + summ + "  temperature: " + temp + " °C");
    }

    private static void getCurrentWeather(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("CURRENT WEATHER:");
        String summary = rootNode.path("current").get("summary").asText();
        double temperature = rootNode.path("current").get("temperature").asDouble();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeNow = String.valueOf(dateTime.format(formatter));
        LOGGER.info("time: " + timeNow + " summary: " + summary + "  temperature: " + temperature + " °C");

    }
}
