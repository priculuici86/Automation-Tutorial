package Tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertTestVar3 extends SharedData {

    @Test
    public void metodaTest() {


        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnAlertFrameWindowSubmenu();

        AlertPage alertPage=new AlertPage(driver);
        alertPage.interactWithAcceptAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithPromtAlert("La multi ani");

    }
}
