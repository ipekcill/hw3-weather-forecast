package com.example.weatherforecastclientapi.controller;

import com.example.weatherforecastclientapi.client.dto.response.WeatherApiResponseDto;
import com.example.weatherforecastclientapi.service.impl.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherServiceImpl weatherService;

    @GetMapping("/daily")
    public ResponseEntity<WeatherApiResponseDto> getDaily(@RequestParam String city, @RequestParam String country) {
        WeatherApiResponseDto response = weatherService.getDaily(city,country);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/weekly")
    public ResponseEntity<WeatherApiResponseDto> getWeekly(@RequestParam String city, @RequestParam String country) {
        WeatherApiResponseDto response = weatherService.getWeekly(city,country);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/monthly")
    public ResponseEntity<WeatherApiResponseDto> getMonthly(@RequestParam String city, @RequestParam String country) {
        WeatherApiResponseDto response = weatherService.getMonthly(city,country);
        return ResponseEntity.ok(response);
    }
}
