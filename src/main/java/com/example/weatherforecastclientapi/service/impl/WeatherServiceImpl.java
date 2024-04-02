package com.example.weatherforecastclientapi.service.impl;

import com.example.weatherforecastclientapi.client.dto.response.MyWeatherApiResponse;
import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;
import com.example.weatherforecastclientapi.converter.ResponseConverter;
import com.example.weatherforecastclientapi.service.IWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements IWeatherService {
    private final WeatherApiServiceImpl weatherApiService;
    private final ResponseConverter responseConverter;

    @Override
    public MyWeatherApiResponse getWeatherForecast(String city, String country, String choice) {
        WeatherApiResponseDto response1 = weatherApiService.callVisualCrossingApi(city, country, choice);
        return responseConverter.toMyWeatherApiResponse(response1);
    }

}
