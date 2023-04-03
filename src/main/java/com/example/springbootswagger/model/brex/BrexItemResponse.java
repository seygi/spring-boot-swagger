package com.example.springbootswagger.model.brex;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BrexItemResponse {
    private static final DateTimeFormatter ISO_8601_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    @Getter
    @Setter
    private String company;
    @Getter
    @Setter
    @JsonAdapter(DateTimeAdapter.class)
    @SerializedName("created_at")
    private LocalDateTime createdAt;
    @Getter
    @Setter
    private String name;
}