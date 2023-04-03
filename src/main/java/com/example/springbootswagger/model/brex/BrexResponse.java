package com.example.springbootswagger.model.brex;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BrexResponse {
    @Getter
    @Setter
    @SerializedName("data")
    private List<BrexItemResponse> data;
}
