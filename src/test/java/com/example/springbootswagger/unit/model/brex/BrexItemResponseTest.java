package com.example.springbootswagger.unit.model.brex;

import com.example.springbootswagger.model.brex.BrexItemResponse;
import org.junit.jupiter.api.Test;
import java.time.ZonedDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class BrexItemResponseTest {

    @Test
    public void testSetAndGetCompany() {
        BrexItemResponse response = new BrexItemResponse();
        response.setCompany("Brex");
        assertEquals("Brex", response.getCompany());
    }

    @Test
    public void testSetAndGetCreatedAt() {
        BrexItemResponse response = new BrexItemResponse();
        ZonedDateTime now = ZonedDateTime.now();
        response.setCreatedAt(now);
        assertEquals(now, response.getCreatedAt());
    }

    @Test
    public void testSetAndGetName() {
        BrexItemResponse response = new BrexItemResponse();
        response.setName("John Doe");
        assertEquals("John Doe", response.getName());
    }
}
