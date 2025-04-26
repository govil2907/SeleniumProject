package sampleapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/goviladapa/Selenium/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.apple.com/");
        Thread.sleep(2000,2000);
        driver.quit();
    }
}
