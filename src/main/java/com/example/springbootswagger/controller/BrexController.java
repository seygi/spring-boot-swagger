package com.example.springbootswagger.controller;

import com.example.springbootswagger.model.brex.BrexResponse;
import com.example.springbootswagger.service.BrexService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/brex")
public class BrexController {
    private final BrexService brexService;

    public BrexController(BrexService brexService) {
        this.brexService = brexService;
    }

    @GetMapping()
    public ResponseEntity<BrexResponse> makeBrexRequest() throws IOException {
        var brexResponse = brexService.brexRequestUsingLibrariesFromEmail();
        return new ResponseEntity<>(brexResponse, HttpStatus.OK);
    }
}