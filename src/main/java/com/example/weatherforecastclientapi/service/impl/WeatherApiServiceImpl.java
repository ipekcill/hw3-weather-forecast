package com.example.weatherforecastclientapi.service.impl;

import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;
import com.example.weatherforecastclientapi.exception.BusinessException;
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
    public WeatherApiResponseDto callVisualCrossingApi(String city, String country, String choice) {
        String endpoint;
        if (choice == null) {
            endpoint = apiUrl + city + "," + country + "?include=days&unitGroup=metric&key=" + apiKey;
        } else {
            switch (choice) {
                case "daily" ->
                        endpoint = apiUrl + city + "," + country + "/" + LocalDate.now() + "?include=days&unitGroup=metric&key=" + apiKey;
                case "weekly" ->
                        endpoint = apiUrl + city + "," + country + "/next7days?include=days&unitGroup=metric&key=" + apiKey;
                case "monthly" ->
                        endpoint = apiUrl + city + "," + country + "/next30days?include=days&unitGroup=metric&key=" + apiKey;
                default -> endpoint = apiUrl + city + "," + country + "?include=days&unitGroup=metric&key=" + apiKey;
            }
        }
        try {
            return restTemplate.getForObject(endpoint, WeatherApiResponseDto.class);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /*@Override
    public WeatherApiResponseDto makeAWeeklyRequest(String city, String country) {
        String endpoint = apiUrl + city + "," + country + "/next7days?include=days&unitGroup=metric&key=" + apiKey;
        return restTemplate.getForObject(endpoint, WeatherApiResponseDto.class);
    }

    @Override
    public WeatherApiResponseDto makeAMonthlyRequest(String city, String country) {
        String endpoint = apiUrl + city + "," + country + "/next30days?include=days&unitGroup=metric&key=" + apiKey;
        return restTemplate.getForObject(endpoint, WeatherApiResponseDto.class);
    }*/

}
