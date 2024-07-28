package com.example;
public class AlertController {

    private double temperatureThreshold;
    private double previousTemperature;

    public AlertController(double threshold) {
        this.temperatureThreshold = threshold;
    }

    public void checkForAlerts(double currentTemperature) {
        if (currentTemperature > temperatureThreshold && previousTemperature > temperatureThreshold) {
            triggerAlert("Temperature exceeded threshold!");
        }
        previousTemperature = currentTemperature;
    }

    private void triggerAlert(String message) {
        // Implement alert triggering (console or email)
        System.out.println(message);
    }
}
