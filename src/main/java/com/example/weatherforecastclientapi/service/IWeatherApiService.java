package com.example.weatherforecastclientapi.service;

import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;

public interface IWeatherApiService {
    WeatherApiResponseDto callVisualCrossingApi(String city, String country, String choice);

   /* WeatherApiResponseDto makeAWeeklyRequest(String city, String country);

    WeatherApiResponseDto makeAMonthlyRequest(String city, String country);
*/
}
