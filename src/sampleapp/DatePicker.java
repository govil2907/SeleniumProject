package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/goviladapa/Selenium/" +
                "chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        List<WebElement> closeLogin = driver.findElements(By.xpath(
                "//span[@class='commonModal__close']"));
        if (!closeLogin.isEmpty()){
            closeLogin.get(0).click();
        }
        WebElement departureDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//p[@data-cy='departureDate']")));
        departureDate.click();
        Thread.sleep(2000);
        selectDate("June 2025", "10");
        Thread.sleep(3000);

        String selectedDate = driver.findElement(By.xpath("//p[@data-cy='departureDate']/span[1]")).getText();
        selectedDate.equalsIgnoreCase("10");

        Thread.sleep(3000);
        driver.quit();
    }

    public static void selectDate(String month_year, String day){
        List<WebElement> months = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));
        System.out.println("months count: "+ months.size());

        for (int i=0;i<months.size();i++) {
            if (months.get(i).getText().equals(month_year)) {

                List<WebElement> days = driver.findElements(By.xpath("(//div[@class='DayPicker-Caption']/div)[" + i

                        + "+1]/..//following-sibling::div[@class='DayPicker-Body']//div[@class='DayPicker-Day']//p"));
                System.out.println("days count: "+ days.size());
                for (int j=0;j<days.size();j++){
                    if(days.get(j).getText().equals(day)){
                        days.get(j).click();
                        break;
                    }
                }

            }
        }
    }
}
