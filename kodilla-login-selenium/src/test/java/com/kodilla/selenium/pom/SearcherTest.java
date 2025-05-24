package com.kodilla.selenium.pom;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearcherTest {

    private WebDriver driver;

    private final String BASE_URL = "https://kodilla.com/pl/test/store";

   private final Map<String, Integer> searchQueries = Map.of(
            "NoteBook", 2,
            "School", 1,
            "Brand", 1,
            "Business", 0,
            "Gaming", 1,
            "Powerful", 0
    );

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium-drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @AfterEach
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSearchQueriesReturnExpectedResults() {
        for (String query : searchQueries.keySet()) {
            int expectedCount = searchQueries.get(query);
            int resultCount = getSearchResultCount(query);
            assertEquals(expectedCount, resultCount);
        }
    }

    @Test
    public void testSearchIsCaseInsensitive() {
        for (String query : searchQueries.keySet()) {
            int lowerCaseCount = getSearchResultCount(query.toLowerCase());
            int upperCaseCount = getSearchResultCount(query.toUpperCase());
            assertEquals(lowerCaseCount, upperCaseCount);
        }
    }

    private int getSearchResultCount(String searchPhrase) {
        WebElement inputField = driver.findElement(By.name("search"));
        inputField.clear();
        inputField.sendKeys(searchPhrase);
        inputField.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, (2));
        List<WebElement> results;
        try {
            results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"elements-wrapper\"]/div")));
        } catch (TimeoutException e) {
            results = List.of();
        }
        return results.size();
    }
}