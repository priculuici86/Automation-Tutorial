package mostenireTests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class MostenireBrowserWindowTestObConstr extends SharedData {
/// /Aplicam ideea pt care trebuie sa folosim Obiectul si  Constructorul in automation.
//// Refactorizarea- este implementarea de fiecare data a unui cod pt rezolv. unei situatii,
////Astfel, dublicand f. mul codul, pt. a evita acest lucru apelam la Ob. Constr. cu care v-om face
//// metode de ajutor, cu scopul de a  ne usura munca cand vine vb de implementare a codului.

    /// 1. Facem un paket nou "TabWindowHelper", in care v-om face metode de ajutor specifice window.

    @Test
    public void metodaTest() {
////2. Aici, facem un obiect (tabWindowHelper, pt. ca avem nevoie de metode pt window,
/// sau unelte, ac.v-a apela extern driverul),
///Dp. vom mg la  locul unde prima data avem codul implementat (linia 45) si inlocuim cu codul prescurtat

        TabWindowHelper tabWindowHelper = new TabWindowHelper(driver);

///3. Facem un nou Obiect pt ca avem nevoie de metode specifice Elementelor

        ElementHelper elementHelper = new ElementHelper(driver);

        By alertsFrameWindowsMenu = By.xpath("//h5[text ()='Alerts, Frame & Windows']");
        elementHelper.clickJsLocator(alertsFrameWindowsMenu);

        By browserWindowsSubmenu = By.xpath("//span[text ( )='Browser Windows']");
        elementHelper.clickLocator(browserWindowsSubmenu);

        By newTabClick = By.id("tabButton");
        elementHelper.clickJsLocator(newTabClick);
        System.out.println(driver.getCurrentUrl());

//        List <String> tabs= new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
        ////Nu mai avem nevoie de Lista de tab l.42-45 si o apelam in helper astfel:
        tabWindowHelper.switchToSpecificTabWindow(1);
        System.out.println(driver.getCurrentUrl());
        tabWindowHelper.closeCurrentTabWindow();

        //Dp ce am inchis tab ul ii specificam sa se mute si abia dp, cautam elementul
        /// apelam :
//        driver.switchTo().window(tabs.get(0));
        tabWindowHelper.switchToSpecificTabWindow(0);

        By newWindowClick = By.id("windowButton");
        elementHelper.clickJsLocator(newWindowClick);

//        List <String> windows= new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windows.get(1));
        tabWindowHelper.switchToSpecificTabWindow(1);
        System.out.println(driver.getCurrentUrl());

//        driver.close();
        tabWindowHelper.closeCurrentTabWindow();

//        driver.switchTo().window(tabs.get(0));
        tabWindowHelper.switchToSpecificTabWindow(0);

        By newWindowMessage = By.id("messageWindowButton");
        elementHelper.clickJsLocator(newWindowMessage);


    }
}
