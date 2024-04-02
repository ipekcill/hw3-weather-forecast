package com.example.weatherforecastclientapi.service.impl;

import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;
import com.example.weatherforecastclientapi.service.IWeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WeatherApiServiceImpl implements IWeatherApiService {
    @Value("${visualCrossingAPI.apiUrl}")
    private String apiUrl;

    @Value("${visualCrossingAPI.apiKey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Override
    public WeatherApiResponseDto makeADailyRequest(String city, String country) {

        String now = LocalDate.now().toString();

        String endpoint = apiUrl + country + "/" + city + "/" + now + "?include=days&unitGroup=metric&key=" + apiKey;
        WeatherApiResponseDto weatherInfo = restTemplate.getForObject(endpoint, WeatherApiResponseDto.class);
        return weatherInfo;
    }

    @Override
    public WeatherApiResponseDto makeAWeeklyRequest(String city, String country) {
        String endpoint = apiUrl + country + "/" + city + "/next7days?include=days&unitGroup=metric&key=" + apiKey;
        WeatherApiResponseDto weatherInfo = restTemplate.getForObject(endpoint, WeatherApiResponseDto.class);
        return weatherInfo;
    }

    @Override
    public WeatherApiResponseDto makeAMonthlyRequest(String city, String country) {
        String endpoint = apiUrl + country + "/" + city + "/next30days?include=days&unitGroup=metric&key=" + apiKey;
        WeatherApiResponseDto weatherInfo = restTemplate.getForObject(endpoint, WeatherApiResponseDto.class);
        return weatherInfo;
    }

}
