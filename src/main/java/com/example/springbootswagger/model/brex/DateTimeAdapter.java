package com.example.springbootswagger.model.brex;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//public class DateTimeAdapter extends TypeAdapter<LocalDateTime> {
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//
//    @Override
//    public void write(JsonWriter out, LocalDateTime value) throws IOException {
//        out.value(formatter.format(value));
//    }
//
//    @Override
//    public LocalDateTime read(JsonReader in) throws IOException {
//        String dateStr = in.nextString();
//        return LocalDateTime.parse(dateStr, formatter);
//    }
//}

//public class DateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
////    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
//
//
//    @Override
//    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        String datetime = json.getAsString();
////        return LocalDateTime.parse(datetime, formatter);
//        return OffsetDateTime.parse(datetime).withOffsetSameInstant(ZoneOffset.UTC).toLocalDateTime();
//    }
//
//    @Override
//    public JsonElement serialize(LocalDateTime datetime, Type typeOfSrc, JsonSerializationContext context) {
//        String formattedDateTime = datetime.format(formatter);
////        return new JsonPrimitive(formattedDateTime);
//
//        return new JsonPrimitive(formatter.format(datetime.atOffset(ZoneOffset.UTC)));
//
//    }
//}

public class DateTimeAdapter implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    @Override
    public ZonedDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String datetime = json.getAsString();
        return ZonedDateTime.parse(datetime, formatter);
    }

    @Override
    public JsonElement serialize(ZonedDateTime datetime, Type typeOfSrc, JsonSerializationContext context) {
        String formattedDateTime = datetime.format(formatter);
        return new JsonPrimitive(formattedDateTime);
    }
}