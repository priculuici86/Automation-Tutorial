package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);

    }

    public void interactWithAcceptAlert() {

        elementHelper.clickJsLocator(AlertLocators.alertOkElement);
        alertHelper.acceptAlert();
    }

    public void interactWithTimerAlert() {
        elementHelper.clickJsLocator(AlertLocators.alertTimeElement);
        alertHelper.acceptAlert();

    }

    public void interactWithCancelAlert() {
        elementHelper.clickJsLocator(AlertLocators.confirmElement);
        alertHelper.cancelAlert();

    }

    public void interactWithPromtAlert(String value) {
        elementHelper.clickJsLocator(AlertLocators.promptElement);
        alertHelper.fillAlert(value);

    }
}
