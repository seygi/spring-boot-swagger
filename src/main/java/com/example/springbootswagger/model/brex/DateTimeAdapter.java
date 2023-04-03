package com.example.springbootswagger.model.brex;

import com.nimbusds.jose.shaded.gson.TypeAdapter;
import com.nimbusds.jose.shaded.gson.stream.JsonReader;
import com.nimbusds.jose.shaded.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAdapter extends TypeAdapter<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        out.value(formatter.format(value));
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        String dateStr = in.nextString();
        return LocalDateTime.parse(dateStr, formatter);
    }
}