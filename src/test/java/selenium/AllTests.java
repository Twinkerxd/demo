package selenium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import selenium.Utils.WebWaitUtils;
import selenium.jetbrains.MainPage;
import selenium.nofluffjobs.NoFluffJobsPage;
import selenium.seldev.AlertPage;
import selenium.seldev.WaitPage;
import selenium.solidJobs.SolidJobsPage;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllTests extends BaseSeleniumTest {
    WebWaitUtils webWaitUtils = new WebWaitUtils(driver);

    @Test
    public void checkSearchResults() {
        String expectedResult = "Aqua: The IDE for test automation";
        String actualResult = new MainPage(driver)
                .clickSearchButton()
                .clickSearchInput()
                .sendTextSearchInput("Selenium")
                .clickSearchInput()
                .clickAdvancedSearchButton()
                .getFirstResultTitle()
                .getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkCloseSearchButton() {
        String expectedResult = "Make Your Software Vision a Reality";
        String actualResult = new MainPage(driver)
                .clickSearchButton()
                .clickSearchInput()
                .sendTextSearchInput("Selenium")
                .clickAdvancedSearchButton()
                .clickCloseSearchButton()
                .getMainTitle();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkAquaPageTitle() {
        String expectedResult = "The IDE for test automation";
        String actualResult = new MainPage(driver)
                .clickDeveloperToolsButton()
                .clickAquaSpan()
                .getTitle();

        assertEquals(expectedResult, actualResult);
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

        List<String> actualResult = new MainPage(driver)
                .getMainMenuItems();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkElementProperty() {
        String expectedResult = "https://www.jetbrains.com/#for-teams";
        String actualResult = new MainPage(driver)
                .getForTeamsLink();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkCssColorValue() {
        String color = new MainPage(driver)
                .getForTeamsCSSValue("background-image");

        System.out.println(color);
    }

    @Test
    public void actionMoveToElement() {
        MainPage mainPage = new MainPage(driver);
        mainPage.moveToElement(mainPage.getTeamsLink());
    }

    /**
     * For a single element:
     * explicit wait for a specific element
     * if you need to wait for an element to disappear—use only explicit waits.
     */
    @Test
    public void explicitWaits_1() {
        open("https://www.selenium.dev/selenium/web/dynamic.html");
        WaitPage waitPage = new WaitPage(driver).isAt();
        WebElement element = waitPage.getRedBox0();

        waitPage.clickAddButton();
        webWaitUtils.waitVisibilityOfElement(element);

        Boolean expectedResult = true;
        Boolean actualResult = element.isDisplayed();

        assertEquals(expectedResult, actualResult);
    }

    /**
     * For multiple elements.
     */
    @Test
    public void explicitWaits_2() {
        open("https://www.selenium.dev/selenium/web/dynamic.html");
        WaitPage waitPage = new WaitPage(driver).isAt();

        for (int i = 0; i < 5; i++) {
            String id = "box" + i;
            waitPage.clickAddButton();
            webWaitUtils.waitElementById(id);
        }

        int expectedResult = 5;
        int actualResult = waitPage.getRedBoxElementsList().size();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void explicitWaitWithLambda() {
        open("https://www.selenium.dev/selenium/web/dynamic.html");
        WaitPage waitPage = new WaitPage(driver).isAt();
        waitPage.clickAddButton();
        Boolean expectedResult = true;
        Boolean actualResult = webWaitUtils.isDisplayed(waitPage.getRedBox0());

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void JsAlert() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage(driver).isAt();
        alertPage.clickJsAlertButton();
        webWaitUtils.waitAlertIsPresent().accept();

        String expectedResult = "You successfully clicked an alert";
        String actualResult = alertPage.getResultField().getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void JsConfirmAlert() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage(driver).isAt();
        alertPage.clickJsConfirmButton();
        webWaitUtils.waitAlertIsPresent().accept();

        String expectedResult = "You clicked: Ok";
        String actualResult = alertPage.getResultField().getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void JsCancelAlert() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage(driver).isAt();
        alertPage.clickJsConfirmButton();
        webWaitUtils.waitAlertIsPresent().dismiss();

        String expectedResult = "You clicked: Cancel";
        String actualResult = alertPage.getResultField().getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void JsPromptAlert() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        AlertPage alertPage = new AlertPage(driver).isAt();
        alertPage.clickJsPromptButton();

        webWaitUtils.waitAlertIsPresent();
        String text = "Kappa";
        alertPage.sendKeysToAlert(text).accept();

        String expectedResult = "You entered: " + text;
        String actualResult = alertPage.getResultField().getText();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkTitlesPlans() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Aqua Non-Commercial");
        expectedResult.add("Aqua");
        expectedResult.add("All Products Pack");

        List<String> actualResult = new MainPage(driver)
                .clickDeveloperToolsButton()
                .clickAquaSpan()
                .clickGetAquaButton()
                .getTitlesPlans();

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"raz", "dwa", "tri"})
    public void parameterized(String text) {
        System.out.println(text);
    }

    @Test
    @DisplayName("Name of the test")
    public void noFluffJobs() {
        open("https://nofluffjobs.com/pl/Java?criteria=jobPosition%3D%27qa%20engineer%27");
        NoFluffJobsPage noFluffJobsPage = new NoFluffJobsPage(driver).isAt();
        noFluffJobsPage.clickAcceptCookieButton().clickMoreJobsButton().clickJobLinkAndGetAllTags();

        Map<String, Integer> frequenceMap = new HashMap<>();

        for (String item : noFluffJobsPage.getAllTags()) {
            if (frequenceMap.containsKey(item)) {
                frequenceMap.put(item, frequenceMap.get(item) + 1);
            } else {
                frequenceMap.put(item, 1);
            }
        }

        // Sorting the map by value in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequenceMap.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // Converting the sorted list back to LinkedHashMap to preserve the order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Printing the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    public void solidJobs() {
        open("https://solid.jobs/offers/it;experiences=Regular;categories=Tester;subcategories=In%C5%BCynier%20test%C3%B3w%20automatycznych");
        SolidJobsPage solidJobsPage = new SolidJobsPage(driver).isAt();

        Map<String, Integer> frequenceMap = new HashMap<>();

        for (String item : solidJobsPage.getAllTags()) {
            if (frequenceMap.containsKey(item)) {
                frequenceMap.put(item, frequenceMap.get(item) + 1);
            } else {
                frequenceMap.put(item, 1);
            }
        }

        // Sorting the map by value in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequenceMap.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // Converting the sorted list back to LinkedHashMap to preserve the order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Printing the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }


    public void softAsserts() {
        SoftAssertions softAssertions = new SoftAssertions();

        // First soft assertion
        softAssertions.assertThat(1).as("Проверка первого утверждения").isEqualTo(1);

        // Second soft assertion
        softAssertions.assertThat("Hello").as("Проверка второго утверждения").isEqualTo("World");

        // Third soft assertion
        softAssertions.assertThat(true).as("Проверка третьего утверждения").isFalse();

        // Executing all accumulated assertions
        softAssertions.assertAll();
    }
}
