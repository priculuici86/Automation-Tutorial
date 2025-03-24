package Tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.IndexPage;
import sharedData.SharedData;

public class BrowserWindowTestVar3 extends SharedData {

    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.clickBrowserSubmenu();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(driver);
        browserWindowPage.interactWithSpecificTab();
        browserWindowPage.interactWithSpecificWindow();




    }
}
