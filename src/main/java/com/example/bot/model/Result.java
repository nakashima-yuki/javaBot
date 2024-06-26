package com.example.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <E> Result<E> success(E data) {
        return new Result<>(0,"请求成功",data);
    }

    public static Result error(String message) {
        return new Result(-1,message,null);
    }
}
