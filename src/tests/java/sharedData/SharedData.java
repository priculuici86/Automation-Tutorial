package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    // Aceasta clasa are ca rol sa deschida/ inchida un browser
    // Vom face acest lucru folosind adnotari de TestNG

    public WebDriver driver;
    @BeforeMethod
    public void prepareEnviroment(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com");

    }

    @AfterMethod
    public void clearEnviroment(){
        driver.quit();
    }
}
