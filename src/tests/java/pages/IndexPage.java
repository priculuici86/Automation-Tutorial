package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

import javax.swing.text.html.parser.Element;

public class IndexPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void enterOnAlertFrameWindowMenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsWindowsMenu);
    }

    public void enterOnAlertFrameWindowSubmenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsSubmenu);
    }

    public void clickBrowserSubmenu() {
        elementHelper.clickJsLocator(IndexLocators.browserWindowsSubmenu);
    }

    public void enterOnFrameSubmenu() {
        elementHelper.clickJsLocator(IndexLocators.frameSubmenu);
    }

    public void enterOnFormsMenu() {
        elementHelper.clickJsLocator(IndexLocators.formsMenu);

    }

    public void enterOnFormsSubmenu() {
        elementHelper.clickJsLocator(IndexLocators.practiceFormsSubmenu);
    }

    public void elementsMenu() {
        elementHelper.clickJsLocator(IndexLocators.elementsMenu);
    }

    public void webTableSubmenu() {
        elementHelper.clickJsLocator(IndexLocators.webTableSubmenu);
    }
}

