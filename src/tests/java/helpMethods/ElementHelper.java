package helpMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    public void waitForElementVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
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

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void clickJsLocator(WebElement locator) {
        waitForElementVisible(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", locator);
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
    // Ac metoda primeste un locator(orice locator) si un mesaj la care  te astepti, asteapta dp mesajul respectiv,
    // ia textul ac. si valideaza ca actual message este cel la care te astepti /expected message
    public void validateTextLocator(By locator, String expected){
        waitForElementVisible(locator);
        String actualMessage = driver.findElement(locator).getText();
        Assert.assertEquals(actualMessage, expected);
    }
    //Valideaza continutul textului de pe un element
    public void validateTextContainsElement(WebElement element, String text){
        waitForElementVisible(element);
        Assert.assertTrue(element.getText().contains(text));
    }
    //Metoda care face clear/ element si dupa editeaza valoarea respectiva

    public void clearFilledLocator(By locator, String text){
        waitForElementVisible(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    }


