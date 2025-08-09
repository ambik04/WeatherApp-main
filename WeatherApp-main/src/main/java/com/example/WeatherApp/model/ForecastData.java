package com.example.WeatherApp.model;

public class ForecastData {
    private String date;
    private double temperature;
    private int humidity;

    public ForecastData() {}

    public ForecastData(String date, double temperature, int humidity) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

