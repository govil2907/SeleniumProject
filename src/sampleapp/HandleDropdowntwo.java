package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleDropdowntwo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/goviladapa/Selenium/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.opencart.com/index.php?route=account/register");
        WebElement drpCntryEle = driver.findElement(By.id("input-country"));
        Select drpCntry = new Select(drpCntryEle);
        drpCntry.selectByVisibleText("India");
        Thread.sleep(1000);
        drpCntry.selectByIndex(5);
        Thread.sleep(1000);
        drpCntry.selectByValue("10");
        Thread.sleep(1000);


        driver.quit();
    }
}
