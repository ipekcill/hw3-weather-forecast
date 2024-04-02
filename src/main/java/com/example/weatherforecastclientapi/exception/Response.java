package com.example.weatherforecastclientapi.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Objects;

public class Response {
    private Date timestamp;

    private HttpStatus status;

    private String message;

    public Response(Date timestamp, HttpStatus status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, status, timestamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Response other = (Response) obj;
        return Objects.equals(message, other.message) && status == other.status
                && Objects.equals(timestamp, other.timestamp);
    }

    @Override
    public String toString() {
        return "ErrorResponse [timestamp=" + timestamp + ", status=" + status + ", message=" + message + "]";
    }
}
