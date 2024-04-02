package com.example.weatherforecastclientapi.client.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WeatherApiResponseDto {

    private String address;

    private List<WeatherResponseDto> days;

}
