package com.example.weatherforecastclientapi.client.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponseDto {
    private String datetime;

    private double tempmax;

    private double tempmin;

    private double temp;

    private double feelslike;

    private double humidity;

    private double windspeed;

    private String sunrise;

    private String sunset;

    private String conditions;

    private String description;
}
