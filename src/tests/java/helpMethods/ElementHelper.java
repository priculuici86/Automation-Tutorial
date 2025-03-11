package helpMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {

    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }
    //1.Metoda wait inainte de a face o actiune se asigura ca pag.exista (inainte de a ident. locator)

    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //2. Metoda click-ului simplu
    public void clickLocator(By locator) {
        //chemam metoda si parametru
        waitForElementVisible(locator);
        //Convertim click-ul pt ca ac. e specific unui Web.Elem. nu de un By "locator"
        driver.findElement(locator).click();
    }
    //3.Metoda click-ului JS executor, dar inainte face wait-ul e 2 in 1

    public void clickJsLocator(By locator) {
        waitForElementVisible(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }
    //4. Metoda cu care scriem ceva pe un element - "firstNameElement.sendKeys(firstNameValue);"

    public void fillLocator(By locator, String value) {
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(value);
    }
    // Metoda pt scris si apasat buton

    public void fillPressLocator(By locator, String value, Keys key){
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(key);
    }

    }

}
