package com.example.weatherforecastclientapi.service;

import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;

public interface IWeatherService {
    WeatherApiResponseDto getDaily(String city, String country);

    WeatherApiResponseDto getWeekly(String city, String country);

    WeatherApiResponseDto getMonthly(String city, String country);
}
