package com.example.springbootswagger.controller;

import com.example.springbootswagger.service.KeycloakRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private KeycloakRestService restService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(String username, String password) {
        return restService.login(username, password);
    }

    @PostMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map logout(@RequestParam(value = "refresh_token", name = "refresh_token") String refreshToken) {
        try {
            restService.logout(refreshToken);
            return new HashMap(){{
                put("logout", "true");
            }};
        } catch (Exception e) {
            return new HashMap (){{
                put("logout", "false");
            }};
        }
    }
}
