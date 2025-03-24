package Tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageLocators.IndexLocators;
import pages.FramePages;
import pages.IndexPage;
import sharedData.SharedData;

public class FrameTestVar3 extends SharedData {


    @Test
    public void metodaTest() {

        IndexPage indexPage=new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnFrameSubmenu();

        FramePages framePages = new  FramePages(driver);
        framePages.switchToSpecificTab1();

        framePages.switchToParent();
    }
}

//        ElementHelper elementHelper = new ElementHelper(driver);
//        TabWindowHelper tabWindowHelper=new TabWindowHelper(driver);
//
//        By frameMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
//        elementHelper.clickJsLocator(frameMenu);
//
//        By frameSubmenu = By.xpath("//span[text()='Frames']");
//        elementHelper.clickJsLocator(frameSubmenu);
//
//        tabWindowHelper.switchToSpecificTabWindow1("frame1");
//
////        driver.switchTo().frame("frame1");
//
//       WebElement textElement = driver.findElement (By.id("sampleHeading"));
//        System.out.println(textElement.getText());
//
//        driver.switchTo().parentFrame();
//        driver.switchTo().frame("frame2");
//
//        WebElement textElement2 = driver.findElement(By.id("sampleHeading"));
//        System.out.println(textElement2.getText());



