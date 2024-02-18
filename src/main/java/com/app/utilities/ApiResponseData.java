package com.app.utilities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ApiResponseData<T> {
    private ApiResponseStatus status;
    private T data;

    private LocalDateTime responseTime;

    public ApiResponseData(ApiResponseStatus status, T data, LocalDateTime responseTime) {
        this.status = status;
        this.data = data;
        this.responseTime = responseTime;
    }
}
