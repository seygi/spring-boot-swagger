package com.example.springbootswagger.model.brex;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class BrexItemResponse {
    @Getter
    @Setter
    @SerializedName("company")
    private String company;
    @Getter
    @Setter
    @JsonAdapter(DateTimeAdapter.class)
    @SerializedName("created_at")
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private ZonedDateTime createdAt;
    @Getter
    @Setter
    @SerializedName("name")
    private String name;
}