package com.example.weatherforecastclientapi.client.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MyWeatherApiResponse {
    private AddressDto address;

    private List<MyWeatherResponseDto> days;
}
