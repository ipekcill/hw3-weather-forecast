package com.example.weatherforecastclientapi.service.impl;

import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;
import com.example.weatherforecastclientapi.service.IWeatherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements IWeatherService {
    private final WeatherApiServiceImpl weatherApiService;
    private final ModelMapper modelMapper;

    @Override
    public WeatherApiResponseDto getDaily(String city, String country) {
        WeatherApiResponseDto response1 = weatherApiService.makeADailyRequest(city, country);
        WeatherApiResponseDto response = modelMapper.map(response1, WeatherApiResponseDto.class);
        return response;
    }

    @Override
    public WeatherApiResponseDto getWeekly(String city, String country) {
        WeatherApiResponseDto response1 = weatherApiService.makeAWeeklyRequest(city, country);
        WeatherApiResponseDto response = modelMapper.map(response1, WeatherApiResponseDto.class);
        return response;
    }

    @Override
    public WeatherApiResponseDto getMonthly(String city, String country) {
        WeatherApiResponseDto response1 = weatherApiService.makeAMonthlyRequest(city, country);
        WeatherApiResponseDto response = modelMapper.map(response1, WeatherApiResponseDto.class);
        return response;
    }
}
