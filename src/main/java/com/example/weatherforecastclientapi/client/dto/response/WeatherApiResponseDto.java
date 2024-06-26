package com.example.weatherforecastclientapi.client.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WeatherApiResponseDto {

    private String address;
    private String resolvedAddress;
    private double latitude;
    private double longitude;

    private List<WeatherResponseDto> days;

}
