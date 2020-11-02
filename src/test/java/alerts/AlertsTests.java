package alerts;

import base.baseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends baseTests {
    @Test
   public void testAcceptAlert(){
        var alertsPage= homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert", "Result text is incorrect");
    }
    @Test
    public void testGetTextFromAlert(){
        var alertsPage= homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text= alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }
    @Test
    public void testSetInputInAlert(){
        var alertsPage= homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You entered: "+ text, "Results text incorrect!");
    }
}
