package mostenireTests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class MostenireAlertTest extends SharedData {

    @Test
    public void metodaTest() {
        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper= new AlertHelper(driver);


        By alertsWindowsMenu = By.xpath("//h5[text( )='Alerts, Frame & Windows']");
        elementHelper.clickJsLocator(alertsWindowsMenu);

        By alertsSubmenu = By.xpath("//span[text ( )='Alerts']");
        elementHelper.clickJsLocator(alertsSubmenu);

        By alertOkElement = By.id("alertButton");
        elementHelper.clickJsLocator(alertOkElement);

//        Alert alertOk = driver.switchTo().alert();
//        System.out.println(alertOk.getText());
//        alertOk.accept();
        alertHelper.acceptAlert();


        //2 ALERT OK- se activeaza dp 5 sec
        By alertTimeElement = By.id("timerAlertButton");
        elementHelper.clickJsLocator(alertTimeElement);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alertTimer = driver.switchTo().alert();
//        System.out.println(alertOk.getText());
//        alertOk.accept();
        alertHelper.acceptAlert();

        //3 ALERT OK-CANCEL
        By confirmElement = By.id("confirmButton");
        elementHelper.clickJsLocator(confirmElement);

//        Alert alertOkCancel = driver.switchTo().alert();
//        System.out.println(alertOkCancel.getText());
//        alertOk.dismiss();
        alertHelper.cancelAlert();

        //4 ALERT INTRODUCI VALOARE
        By promptElement = By.id("promtButton");
        elementHelper.clickJsLocator(promptElement);

//        Alert alertPrompt = driver.switchTo().alert();
//        System.out.println(alertPrompt.getText());
//        String alertValue = "este vineri";
//        alertPrompt.sendKeys(alertValue);
//        alertPrompt.accept();
        alertHelper.fillAlert("La multi ani!");

    }
}
