package pages;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.FrameLocators;

public class FramePages {

    private WebDriver driver;
    private ElementHelper elementHelper;
    public TabWindowHelper tabWindowHelper;

    public FramePages(WebDriver driver) {
        this.driver = driver;
        elementHelper= new ElementHelper(driver);
        tabWindowHelper= new TabWindowHelper(driver);

    }
    public void switchToSpecificTab1(){
        tabWindowHelper.switchToSpecificTabWindow1("frame1");
        WebElement textElement = driver.findElement (FrameLocators.textElement);
        System.out.println(textElement.getText());

    }
    public void switchToParent(){
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame2");
        WebElement textElement2 = driver.findElement(FrameLocators.textElement);
        System.out.println(textElement2.getText());
    }
}
