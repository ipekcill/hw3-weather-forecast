package com.example.weatherforecastclientapi.client.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private double latitude;
    private double longitude;
    private String address;
    private String resolvedAddress;
}
