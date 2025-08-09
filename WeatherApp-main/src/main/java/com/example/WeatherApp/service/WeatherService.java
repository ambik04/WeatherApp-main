package com.example.WeatherApp.service;

import com.example.WeatherApp.model.ForecastData;
import com.example.WeatherApp.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherData getCurrentWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                     "&appid=" + apiKey + "&units=metric";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        Map<String, Object> main = (Map<String, Object>) response.get("main");

        double temp = ((Number) main.get("temp")).doubleValue();
        int humidity = ((Number) main.get("humidity")).intValue();

        return new WeatherData(temp, humidity);
    }

    public List<ForecastData> getFiveDayForecast(String city) {
        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city +
                     "&appid=" + apiKey + "&units=metric";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) response.get("list");

        List<ForecastData> forecastList = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 8) { // 8 data points per day (3h interval)
            Map<String, Object> dataPoint = list.get(i);
            Map<String, Object> main = (Map<String, Object>) dataPoint.get("main");

            String date = (String) dataPoint.get("dt_txt");
            double temp = ((Number) main.get("temp")).doubleValue();
            int humidity = ((Number) main.get("humidity")).intValue();

            forecastList.add(new ForecastData(date, temp, humidity));
        }

        return forecastList;
    }
}
