package selenium;

import org.junit.jupiter.api.Test;
import selenium.seldev.AlertPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static selenium.WebAlertUtils.sendKeysToAlert;
import static selenium.WebElementUtils.*;
import static selenium.WebWaitUtils.*;

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
    public void JsCancelAlert() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage();
        alertPage.clickJsConfirmButton();
        waitAlertIsPresent().dismiss();

        String expectedResult = "You clicked: Cancel";
        String actualResult = alertPage.getResultField().getText();

        assertEquals(expectedResult, actualResult);
    }

}
