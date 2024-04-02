package com.example.weatherforecastclientapi.client.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class MyWeatherResponseDto {

    private double currTemp;

    private double avgTemp;

    private double maxTemp;
    private double minTemp;

    private double feelslike;

    private double humidity;

    private String conditions;

    private String description;
}