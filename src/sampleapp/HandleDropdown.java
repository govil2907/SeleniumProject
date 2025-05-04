package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/goviladapa/Selenium/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.bstackdemo.com/");
        driver.findElement(By.xpath("//select"));
        List<WebElement> allOptions = driver.findElements(By.xpath("//select/option"));
        String option = "Highest to lowest";
        for (int i=0; i< allOptions.size(); i++){
            if (allOptions.get(i).getText().contains(option)){
                allOptions.get(i).click();
                System.out.println("clicked");
                break;
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
