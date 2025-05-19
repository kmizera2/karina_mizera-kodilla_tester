package com.kodilla.selenium.allegro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AllegroTestingApp {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\Chrome\\chromedriver-win64\\chromedriver.exe");    // [1]
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.get("https://allegro.pl/");

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement categoryCombo = driver.findElement(By.xpath("//select[@aria-label=\"Kategoria i opcje wyszukiwania\"]"));
        Select categorySelect = new Select(categoryCombo);
        categorySelect.selectByIndex(4);
        WebElement productSearcher = driver.findElement(By.xpath("//input[@placeholder=\"czego szukasz?\"]"));
        productSearcher.sendKeys("Mavic mini");
        WebElement search = driver.findElement(By.xpath("//button[@aria-label=\"szukaj\"]"));
        search.click();
    }
}