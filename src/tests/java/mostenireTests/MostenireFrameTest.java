package mostenireTests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class MostenireFrameTest extends SharedData {


    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(driver);


        By frameMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJsLocator(frameMenu);

        By frameSubmenu = By.xpath("//span[text()='Frames']");
        elementHelper.clickJsLocator(frameSubmenu);

//        driver.switchTo().frame("frame1");
//
//       By textElement = By.id("sampleHeading");
//        System.out.println(textElement.getText());
//
//        driver.switchTo().parentFrame();
//        driver.switchTo().frame("frame2");
//
//       By textElement2 = By.id("sampleHeading");
//        System.out.println(textElement2.getText());

        driver.switchTo().frame("frame1");

        WebElement textElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(textElement.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame2");

        WebElement textElement2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(textElement2.getText());


    }
}
