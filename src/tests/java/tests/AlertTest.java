package tests;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement alertsWindowsMenu = driver.findElement(By.xpath("//h5[text( )='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();",alertsWindowsMenu );

        WebElement alertsSubmenu = driver.findElement(By.xpath("//span[text ( )='Alerts']"));
        executor.executeScript("arguments[0].click();",alertsSubmenu );

        WebElement alertOkElement = driver.findElement(By.id ("alertButton"));
        executor.executeScript("arguments[0].click();",alertOkElement );

     // 1 ALERT   Facem o variabila cu met. swich to().alert- care returneaza focusul pe alerta resp.
     //   si poti in continuare face actiuni de genul ok cancel

        Alert alertOk = driver.switchTo().alert();
        System.out.println(alertOk.getText());
        alertOk.accept();

     //2 ALERT OK- se activeaza dp 5 sec
        WebElement alertTimeElement = driver.findElement(By.id("timerAlertButton"));
        executor.executeScript("arguments[0].click();",alertTimeElement );

    //2.1 pt ca nu se activ imediat ce faci click-ul exista conceptul de wait: sunt de 2 tipuri
    // IMPLICIT: (se adauga la inceputul codului si are rol sa vegheze liniile de cod dedesubt, cand apare
    // driver.findElement se activeaza in astepta 5 secunde de ex.si dp sa gaseasca elem.
     // W. IMPLICIT  ar fi  linia 42/43 + linia de sus 19:

     //W. EXPLICIT: linia 42/43 +  Se scrie in int.codului in zona cu propl./cade testul

     // LOGICA: Faci un W. Expl. in care ii driver-ul si timpul maxim asteptare  dp chemi
     // waitul si  pui conditia ( sa astepte dp prezenta unei alerte).

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

       Alert alertTimer = driver.switchTo().alert();
       System.out.println(alertOk.getText());
       alertOk.accept();

     //3 ALERT OK-CANCEL
        WebElement confirmElement = driver.findElement(By.id("confirmButton"));
        executor.executeScript("arguments[0].click();",confirmElement );

        Alert alertOkCancel = driver.switchTo().alert();
        System.out.println(alertOkCancel.getText());
        alertOk.dismiss();

     //4 ALERT INTRODUCI VALOARE
       WebElement promptElement = driver.findElement(By.id("promtButton"));
       executor.executeScript("arguments[0].click();",promptElement );

       Alert alertPrompt = driver.switchTo().alert();
       System.out.println(alertPrompt.getText());
       String alertValue= "este vineri";
       alertPrompt.sendKeys(alertValue);
       alertPrompt.accept();

    }
}
