package com.example.WeatherApp.model;

public class WeatherData {
    private double temperature;
    private int humidity;

    public WeatherData() {}

    public WeatherData(double temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}

