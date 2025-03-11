package helpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {
    public WebDriver driver;

    public AlertHelper(WebDriver driver) {

        this.driver = driver;
    }

    //Aici utilizam o metoda l.18 si o var. l.19 specifica pt wait-ul unei Alerte
    public void waitForAlertVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    // Mai jos trebuie sa construim combinatiile  pt o alerta, avem nevoie de 3 metode:
    //1. cand o accepti, 2. cand o inchizi/ dismiss, 3. cand scrii ceva pe ea.
//1.
    public void acceptAlert() {
        waitForAlertVisible();
        Alert alertOk = driver.switchTo().alert();
        System.out.println(alertOk.getText());
        alertOk.accept();
    }
//2.
    public void cancelAlert() {
        waitForAlertVisible();
        Alert alertOk = driver.switchTo().alert();
        System.out.println(alertOk.getText());
        alertOk.dismiss();
    }
//3.
    public void fillAlert(String value) {
        waitForAlertVisible();
        Alert alertOk = driver.switchTo().alert();
        System.out.println(alertOk.getText());
        alertOk.sendKeys(value);
        alertOk.accept();
    }
}
