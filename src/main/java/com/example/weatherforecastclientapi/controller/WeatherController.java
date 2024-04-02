package com.example.weatherforecastclientapi.controller;

import com.example.weatherforecastclientapi.client.dto.response.MyWeatherApiResponse;
import com.example.weatherforecastclientapi.controller.model.ApiResponse;
import com.example.weatherforecastclientapi.service.impl.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherServiceImpl weatherService;

    @GetMapping
    public ResponseEntity<ApiResponse<MyWeatherApiResponse>> getWeatherForecast(@RequestParam String city,
                                                                                @RequestParam String country,
                                                                                @RequestParam(required = false) String choice) {
        MyWeatherApiResponse response = weatherService.getWeatherForecast(city, country, choice);
        ApiResponse<MyWeatherApiResponse> apiResponse = ApiResponse.<MyWeatherApiResponse>builder()
                .data(response)
                .message("Weather forecast taken")
                .dateTime(LocalDate.now())
                .success(true)
                .statusCode(HttpStatus.OK.value())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
