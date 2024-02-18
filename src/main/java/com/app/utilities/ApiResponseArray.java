package com.app.utilities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ApiResponseArray<T> {
    private ApiResponseStatus status;
    private List<T> data;

    private LocalDateTime responseTime;

    public ApiResponseArray(ApiResponseStatus status, List<T> data, LocalDateTime responseTime) {
        this.status = status;
        this.data = data;
        this.responseTime = responseTime;
    }
}
