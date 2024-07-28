package com.example; // Ensure this matches the package of AlertManager

import org.junit.Test;

public class AlertControllerTest {

    @Test
    public void testAlertTriggering() {
        AlertController alertManager = new AlertController(35.0);

        alertManager.checkForAlerts(30.0);
        alertManager.checkForAlerts(36.0);
        alertManager.checkForAlerts(36.0);
    }
}
