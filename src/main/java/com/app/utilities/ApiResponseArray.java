package com.app.utilities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ApiResponseArray<T> {
    private String status;
    private List<T> data;

    private LocalDateTime responseTime;
}
