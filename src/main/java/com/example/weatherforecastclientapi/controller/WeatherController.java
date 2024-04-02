package com.example.weatherforecastclientapi.controller;

import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;
import com.example.weatherforecastclientapi.service.impl.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherServiceImpl weatherService;

    @GetMapping("/daily/{city}")
    public ResponseEntity<WeatherApiResponseDto> getDaily(@PathVariable String city, @PathVariable String country) {
        WeatherApiResponseDto response = weatherService.getDaily(city,country);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/weekly/{city}")
    public ResponseEntity<WeatherApiResponseDto> getWeekly(@PathVariable String city, @PathVariable String country) {
        WeatherApiResponseDto response = weatherService.getWeekly(city,country);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/monthly/{city}")
    public ResponseEntity<WeatherApiResponseDto> getMonthly(@PathVariable String city, @PathVariable String country) {
        WeatherApiResponseDto response = weatherService.getMonthly(city,country);
        return ResponseEntity.ok(response);
    }
}
