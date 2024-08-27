package selenium;

import org.junit.jupiter.api.Test;
import selenium.seldev.AlertPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static selenium.WebElementUtils.open;
import static selenium.WebElementUtils.waitAlertIsPresent;

public class DebugTests extends BaseSeleniumTest{

    @Test
    public void JsConfirmAlert() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage();
        alertPage.clickJsConfirmButton();
        waitAlertIsPresent().accept();

        String expectedResult = "You clicked: Ok";
        String actualResult = alertPage.getResultField().getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void JsAlert() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage();
        alertPage.clickJsAlertButton();
        waitAlertIsPresent().accept();

        String expectedResult = "You successfully clicked an alert";
        String actualResult = alertPage.getResultField().getText();

        assertEquals(expectedResult, actualResult);
    }
}
