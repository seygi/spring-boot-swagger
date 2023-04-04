package com.example.springbootswagger.unit.model.brex;

import com.example.springbootswagger.model.brex.BrexItemResponse;
import com.example.springbootswagger.model.brex.BrexResponse;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrexResponseTest {

    @Test
    public void testGetterSetter() {
        // Create a sample BrexItemResponse object
        ZonedDateTime date = ZonedDateTime.now();
        BrexItemResponse item = new BrexItemResponse();
        item.setCompany("Brex");
        item.setCreatedAt(date);
        item.setName("John Doe");

        // Create a list of BrexItemResponse objects
        List<BrexItemResponse> items = new ArrayList<>();
        items.add(item);

        // Create a BrexResponse object and set the values using the setter methods
        BrexResponse response = new BrexResponse();
        response.setData(items);

        // Test the getter methods to check if the values were set correctly
        assertEquals(items, response.getData());
    }
}
