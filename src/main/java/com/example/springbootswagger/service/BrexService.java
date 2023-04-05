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

        result = "{\"data\":[{\"company\":\"Brex\",\"created_at\":\"2017-01-01T01:13:36Z\",\"name\":\"Pedro Franceschi\"},{\"company\":\"Apple\",\"created_at\":\"1976-04-01T01:13:36-03:00\",\"name\":\"Steve Jobs\"}]}";

        BrexResponse brexResponse = new Gson().fromJson(result, BrexResponse.class);

        return brexResponse;

        /*
          LocalDateTime now = LocalDateTime.now();
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          String formattedDateTime = now.format(formatter);
          *
          String dateTimeString = "2023-04-05 10:30:00";
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        */
    }

}
