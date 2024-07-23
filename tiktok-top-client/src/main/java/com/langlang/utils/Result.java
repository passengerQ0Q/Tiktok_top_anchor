package com.langlang.utils;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Result<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    private Result(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters...

    public static <T> Result<T> success(T data) {
        return new Result<>(true, 200, "Success", data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(true, 200, message, data);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(false, 500, message, null);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(false, code, message, null);
    }

    public static <T> Result<T> fail(String message, T data) {
        return new Result<>(false, 500, message, data);
    }

    public static <T> Result<T> fail(int code, String message, T data) {
        return new Result<>(false, code, message, data);
    }
}
