package selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.noFluffJobsPage.NoFluffJobsPage;
import selenium.jetbrains.MainPage;
import selenium.seldevpages.AlertPage;
import selenium.seldevpages.WaitPage;
import selenium.solidJobs.SolidJobsPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllTests extends BaseSeleniumTest {

    @Test
    public void checkSearchResults() {
        String expectedResult = "Aqua: The IDE for test automation";
        String actualResult = new MainPage().clickSearchButton().clickSearchInput().sendTextSearchInput("Selenium").clickSearchInput().clickAdvancedSearchButton().getResult();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkCloseSearchButton() {
        String expectedResult = "Make Your Software Vision a Reality";
        String actualResult = new MainPage().clickSearchButton().clickSearchInput().sendTextSearchInput("Selenium").clickAdvancedSearchButton().clickCloseSearchButton().getMainTitle();

        assertEquals(expectedResult, actualResult);


    }

    @Test
    public void checkAquaPageTitle() {
        String expectedResult = new MainPage().clickDeveloperToolsButton().clickAquaSpan().getTitle();
        assertEquals(expectedResult, "The IDE for test automation");
    }

    @Test
    public void checkMainMenuItems() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Developer Tools");
        expectedResult.add("Team Tools");
        expectedResult.add("Education");
        expectedResult.add("Solutions");
        expectedResult.add("Support");
        expectedResult.add("Store");

        List<String> actualResult = new MainPage().getMainMenuItems();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkElementProperty() {
        String expectedResult = "https://www.jetbrains.com/#for-teams";
        String actualResult = new MainPage().getForTeamsLink();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkCssColorValue() {
        String color = new MainPage().getForTeamsCSSValue("background-image");
        System.out.println(color);
    }

    @Test
    public void actionMoveToElement() throws InterruptedException {
        new MainPage();
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(driver.findElement(By.cssSelector("a[href='#for-teams']"))).build().perform();
        Thread.sleep(1000);
    }

    /**
     * Для одного элемента
     * явное ожидание для конкретного элемента
     * если нужно дождаться пока элемент пропадёт - только явные ожидания
     */
    @Test
    public void explicitWaits_1() {
        open("https://www.selenium.dev/selenium/web/dynamic.html");
        WaitPage waitPage = new WaitPage();
        WebElement element = waitPage.getRedBox0();

        waitPage.clickAddButton().waitVisibilityOfElement(element);

        Boolean expectedResult = true;
        Boolean actualResult = element.isDisplayed();

        assertEquals(expectedResult, actualResult);
    }

    /**
     * Для нескольких элементов
     */
    @Test
    public void explicitWaits_2() {
        open("https://www.selenium.dev/selenium/web/dynamic.html");
        WaitPage waitPage = new WaitPage();

        for (int i = 0; i < 5; i++) {
            System.out.println("=========== " + i);
            waitPage.clickAddButton();
            waitPage.waitRedBoxElementById(i);
        }
        int expectedResult = 5;
        int actualResult = waitPage.getRedBoxElementsList().size();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void explicitWaitWithLambda() {

        open("https://www.selenium.dev/selenium/web/dynamic.html");
        WaitPage waitPage = new WaitPage();
        waitPage.clickAddButton();
        Boolean expectedResult = true;
        Boolean actualResult = isDisplayed(waitPage.getRedBox0());

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void alert_1() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage();
        alertPage.waitElementByXpath("//button[text()='Click for JS Alert']");
        alertPage.getAlertElementByXpath("//button[text()='Click for JS Alert']").click();
        alertPage.waitAlertIsPresent().accept();

        String expectedResult = "You successfully clicked an alert";
        String actualResult = alertPage.waitVisibilityOfElementById("result").getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void alert_2() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage();
        alertPage.waitElementByXpath("//button[text()='Click for JS Confirm']");
        alertPage.getAlertElementByXpath("//button[text()='Click for JS Confirm']").click();
        alertPage.waitAlertIsPresent().accept();

        String expectedResult = "You clicked: Ok";
        String actualResult = alertPage.waitVisibilityOfElementById("result").getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void alert_3() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage();

        alertPage.waitElementByXpath("//button[text()='Click for JS Confirm']");
        alertPage.getAlertElementByXpath("//button[text()='Click for JS Confirm']").click();
        alertPage.waitAlertIsPresent().dismiss();

        String expectedResult = "You clicked: Cancel";
        String actualResult = alertPage.waitVisibilityOfElementById("result").getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void alert_4() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage();
        alertPage.waitElementByXpath("//button[text()='Click for JS Prompt']");
        alertPage.getAlertElementByXpath("//button[text()='Click for JS Prompt']").click();

        Alert alert = alertPage.waitAlertIsPresent();
        String text = "Kappa";
        alert.sendKeys(text);
        alert.accept();

        String expectedResult = "You entered: " + text;
        String actualResult = alertPage.waitVisibilityOfElementById("result").getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkTitlesPlans() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Aqua Non-Commercial");
        expectedResult.add("Aqua");
        expectedResult.add("All Products Pack");

        List<String> actualResult = new MainPage().clickDeveloperToolsButton().clickAquaSpan().clickAquaButton().getTitlesPlans();

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"raz", "dwa", "tri"})
    public void parameterized(String text) {
        System.out.println(text);
    }

    @Test
    public void noFluffJobs() {
        open("https://nofluffjobs.com/pl/Java?criteria=jobPosition%3D%27qa%20engineer%27");
        NoFluffJobsPage noFluffJobsPage = new NoFluffJobsPage();
        noFluffJobsPage.clickAcceptCookieButton().clickMoreJobsButton().clickJobLinkAndGetAllTags();

        Map<String, Integer> frequenceMap = new HashMap<>();

        for (String item : noFluffJobsPage.getAllTags()) {
            if (frequenceMap.containsKey(item)) {
                frequenceMap.put(item, frequenceMap.get(item) + 1);
            } else {
                frequenceMap.put(item, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : frequenceMap.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    @Test
    public void solidJobs() {
        open("https://solid.jobs/offers/it;experiences=Regular;categories=Tester;subcategories=In%C5%BCynier%20test%C3%B3w%20automatycznych");
        SolidJobsPage solidJobsPage = new SolidJobsPage();

        Map<String, Integer> frequenceMap = new HashMap<>();

        for (String item : solidJobsPage.getAllTags()) {
            if (frequenceMap.containsKey(item)) {
                frequenceMap.put(item, frequenceMap.get(item) + 1);
            } else {
                frequenceMap.put(item, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : frequenceMap.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

}
