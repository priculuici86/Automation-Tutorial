package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class FrameTest extends SharedData {

 // Un "iFrame"  este o pagina mica intr-o pag. mare (principala) si poate fi identificat dupa atributu:
 // Nume, Id sau WebElement

    @Test
    public void metodaTest() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement frameMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", frameMenu);

        WebElement frameSubmenu = driver.findElement(By.xpath("//span[text()='Frames']"));
        executor.executeScript("arguments[0].click();", frameSubmenu);

//Metoda "parentFrame()" revine la pag. principala/ parinte, intrucat seleniu nu stie sa faca asta
//Metoda switch muta focusu de pe un iframe pe altul

        driver.switchTo().frame("frame1");

        WebElement textElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(textElement.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame2");

        WebElement textElement2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(textElement2.getText());

    }
}
