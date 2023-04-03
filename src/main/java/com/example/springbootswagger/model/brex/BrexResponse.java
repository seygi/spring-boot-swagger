package com.example.springbootswagger.model.brex;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BrexResponse {
    @Getter
    @Setter
    private List<BrexItemResponse> data;
}
