package com.example.springbootswagger.service;

import com.example.springbootswagger.model.brex.BrexResponse;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BrexService {
    public BrexResponse brexRequestUsingLibrariesFromEmail() throws IOException {

        String url = "https://platform.brexapis.com/interview/test";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String result = response.body().string();

        BrexResponse brexResponse = new Gson().fromJson(result, BrexResponse.class);

        return brexResponse;
//        String json = new Gson().toJson(brexResponse);
//        System.out.println(json);
    }

}
