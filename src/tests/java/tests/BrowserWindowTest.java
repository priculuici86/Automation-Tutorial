package tests;

import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowTest extends SharedData {


    @Test
    public void metodaTest() {

TabWindowHelper tabWindowHelper=new TabWindowHelper(driver);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text ()='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();",alertsFrameWindowsMenu);

        WebElement browserWindowsSubmenu = driver.findElement(By.xpath("//span[text ( )='Browser Windows']"));
        executor.executeScript("arguments[0].click();",browserWindowsSubmenu);


        WebElement newTabClick = driver.findElement(By.id("tabButton"));
        executor.executeScript("arguments[0].click();",newTabClick);
//Aici identifica URL-ul curent
        System.out.println(driver.getCurrentUrl());

// Facem o lista in care getWindowHandles indentifica cate tab uri ai deschise si le retur.intr-o lista de stringuri
        List <String> tabs= new ArrayList<>(driver.getWindowHandles());

//   Specificam pe care tab sa se mute focusul (ex. get 1/ adica tab 2)
        driver.switchTo().window(tabs.get(1));

        System.out.println(driver.getCurrentUrl());

     //Testul pica  dc nu inchidem pag. pe care e focusat/ tab2(get1), nu stie Se. sa se mute:
        driver.close();
     //Dp ce am inchis tab ul ii specificam sa se mute si abia dp, cautam elementul
        driver.switchTo().window(tabs.get(0));

        WebElement newWindowClick = driver.findElement(By.id("windowButton"));
        executor.executeScript("arguments[0].click();",newWindowClick);

        List <String> windows= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        System.out.println(driver.getCurrentUrl());
        driver.close();

        driver.switchTo().window(tabs.get(0));

        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        executor.executeScript("arguments[0].click();",newWindowMessage);



    }
}
