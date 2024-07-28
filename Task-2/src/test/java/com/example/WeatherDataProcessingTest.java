package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.gson.JsonObject;
import java.io.IOException;

public class WeatherDataProcessingTest {

    @Test
    public void testEndToEndProcessing() {
        WeatherDataRetriever fetcher = new WeatherDataRetriever();
        WeatherDataProcessor processor = new WeatherDataProcessor();
        WeatherStorage storage = new WeatherStorage();
        AlertController alertManager = new AlertController(35.0);

        try {
            JsonObject data = fetcher.getWeatherData("Delhi");
            double tempKelvin = data.getAsJsonObject("main").get("temp").getAsDouble();
            double tempCelsius = WeatherDataProcessor.kelvinToCelsius(tempKelvin);
            storage.addWeatherData("2024-07-27", tempCelsius);

            DailyWeatherSummary summary = storage.getDailySummary("2024-07-27");
            assertNotNull("Summary should not be null", summary);

            alertManager.checkForAlerts(tempCelsius);

        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
}

