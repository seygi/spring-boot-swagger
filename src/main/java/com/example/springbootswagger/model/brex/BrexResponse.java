package com.example.springbootswagger.model.brex;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class BrexResponse {
    @Getter
    @Setter
    @SerializedName("data")
    private List<BrexItemResponse> data;
}
