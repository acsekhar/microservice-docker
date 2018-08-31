package com.samples;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SmokeTest {
    private String sample = "Feature team has to add integration tests";

    @Test
    public void smokeTest() {

        assertTrue(sample.contains("Feature team"));
    }
}
