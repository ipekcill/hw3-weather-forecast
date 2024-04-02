package com.example.weatherforecastclientapi.client.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(conditions, datetime, description, feelslike, humidity, sunrise, sunset, temp, tempmax,
                tempmin, windspeed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeatherResponseDto other = (WeatherResponseDto) obj;
        return Objects.equals(conditions, other.conditions) && Objects.equals(datetime, other.datetime)
                && Objects.equals(description, other.description)
                && Double.doubleToLongBits(feelslike) == Double.doubleToLongBits(other.feelslike)
                && Double.doubleToLongBits(humidity) == Double.doubleToLongBits(other.humidity)
                && Objects.equals(sunrise, other.sunrise) && Objects.equals(sunset, other.sunset)
                && Double.doubleToLongBits(temp) == Double.doubleToLongBits(other.temp)
                && Double.doubleToLongBits(tempmax) == Double.doubleToLongBits(other.tempmax)
                && Double.doubleToLongBits(tempmin) == Double.doubleToLongBits(other.tempmin)
                && Double.doubleToLongBits(windspeed) == Double.doubleToLongBits(other.windspeed);
    }
}
