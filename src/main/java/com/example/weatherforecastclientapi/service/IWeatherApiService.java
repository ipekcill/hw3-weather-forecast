package com.example.weatherforecastclientapi.service;

import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;

public interface IWeatherApiService {
    WeatherApiResponseDto makeADailyRequest(String city, String country);

    WeatherApiResponseDto makeAWeeklyRequest(String city, String country);

    WeatherApiResponseDto makeAMonthlyRequest(String city, String country);

}
