package com.example.weatherforecastclientapi.service;

import com.example.weatherforecastclientapi.client.dto.response.MyWeatherApiResponse;

public interface IWeatherService {
    MyWeatherApiResponse getWeatherForecast(String city, String country, String choice);

    /*WeatherApiResponseDto getWeekly(String city, String country);

    WeatherApiResponseDto getMonthly(String city, String country);*/
}
