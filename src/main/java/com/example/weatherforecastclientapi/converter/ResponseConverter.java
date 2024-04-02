package com.example.weatherforecastclientapi.converter;

import com.example.weatherforecastclientapi.client.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ResponseConverter {
    public MyWeatherApiResponse toMyWeatherApiResponse(WeatherApiResponseDto weatherApiResponseDto) {
        AddressDto addressDto = AddressDto.builder()
                .address(weatherApiResponseDto.getAddress())
                .latitude(weatherApiResponseDto.getLatitude())
                .longitude(weatherApiResponseDto.getLongitude())
                .resolvedAddress(weatherApiResponseDto.getResolvedAddress())
                .build();
        MyWeatherApiResponse myWeatherApiResponse = MyWeatherApiResponse.builder()
                .address(addressDto)
                .build();

        List<MyWeatherResponseDto> myWeatherResponseList = new ArrayList<>();

        List<WeatherResponseDto> weatherResponseDtoList = weatherApiResponseDto.getDays();
        for (WeatherResponseDto dto : weatherResponseDtoList) {
            double minTemp = dto.getTempmin();
            double maxTemp = dto.getTempmax();
            double avgTemp = (minTemp + maxTemp) / 2;

            MyWeatherResponseDto myWeatherResponseDto = MyWeatherResponseDto.builder()
                    .avgTemp(avgTemp)
                    .currTemp(dto.getTemp())
                    .maxTemp(dto.getTempmax())
                    .minTemp(dto.getTempmin())
                    .feelslike(dto.getFeelslike())
                    .humidity(dto.getHumidity())
                    .conditions(dto.getConditions())
                    .description(dto.getDescription())
                    .build();

            myWeatherResponseList.add(myWeatherResponseDto);
        }

        myWeatherApiResponse.setDays(myWeatherResponseList);

        return myWeatherApiResponse;
    }
}