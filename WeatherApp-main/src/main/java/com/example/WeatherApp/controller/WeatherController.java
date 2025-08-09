package com.example.WeatherApp.controller;

import com.example.WeatherApp.model.ForecastData;
import com.example.WeatherApp.model.WeatherData;
import com.example.WeatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    //Default city = Delhi if not passed
    @GetMapping("/current")
    public ResponseEntity<WeatherData> getCurrent(@RequestParam(required = false, defaultValue = "Delhi") String city) {
        WeatherData currentWeather = weatherService.getCurrentWeather(city);
        return ResponseEntity.ok(currentWeather);
    }

    //Default city = Delhi if not passed
    @GetMapping("/forecast")
    public ResponseEntity<List<ForecastData>> getForecast(@RequestParam(required = false, defaultValue = "Delhi") String city) {
        List<ForecastData> forecast = weatherService.getFiveDayForecast(city);
        return ResponseEntity.ok(forecast);
    }
}
