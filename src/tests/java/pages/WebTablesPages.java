package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static pageLocators.PracticFormsLocators.submitElement;
import static pageLocators.WebTablesLocators.*;

public class WebTablesPages {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public WebTablesPages(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void verifyTableContent(int expectedTableRowListElement) {
        List<WebElement> tablesRowsList = driver.findElements(tablesRowListElement);
        Assert.assertEquals(tablesRowsList.size(), expectedTableRowListElement, "Valoarea initiala nu este 3");
    }


    public void addNewRecordButtonClick() {
        elementHelper.clickJsLocator(addElement);
    }


    public void fillFirstName(String firstNameValue) {
        elementHelper.fillLocator(firstNameElement, firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        elementHelper.fillLocator(lastNameElement, lastNameValue);
    }

    public void fillEmail(String userEmailValue) {
        elementHelper.fillLocator(userEmailElement, userEmailValue);
    }

    public void fillAge(String ageValue) {
        elementHelper.fillLocator(ageElement, ageValue);
    }

    public void fillSalary(String salaryValue) {
        elementHelper.fillLocator(salaryElement, salaryValue);
    }

    public void fillDepartment(String departmentValue) {
        elementHelper.fillLocator(departmentElement, departmentValue);
    }

    public void submitClick() {
        elementHelper.clickJsLocator(submitElement);
    }

//    public void clearText(String firstNameValue) {
//        elementHelper.clearFilledLocator(firstNameElement, firstNameValue);
//
//    }


    public void editClick() {
        elementHelper.clickJsLocator(editElement);
    }

    public void verifyTableContent(int expectedSize, String firstNameValue, String lastNameValue, String userEmailValue,
                                   String ageValue, String salaryValue, String departmentValue) {
        List<WebElement> tablesRowsList = driver.findElements(tablesRowListElement);
        Assert.assertEquals(tablesRowsList.size(), expectedSize, "Valoarea actuala a tabelului nu este 4");
        elementHelper.validateTextContainsElement(tablesRowsList.get(3), firstNameValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3), lastNameValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3), userEmailValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3), ageValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3), salaryValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3), departmentValue);
    }

    public void deleteRecords() {
        elementHelper.clickJsLocator(deletElement);
    }

}
////???? NU POT STERGE  INAINTE TEXTUL DE PE RANDUL COMPLETAT SI DUPA SA COMPLETEZ CU ALTE VALORI