package mostenireTests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class MostenireWebTableTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);


        By elementsMenu = By.xpath("//h5[text()='Elements']");
        elementHelper.clickJsLocator(elementsMenu);

        By webTableSubmenu = By.xpath("//span[text()='Web Tables']");
        elementHelper.clickJsLocator(webTableSubmenu);

//VALIDARE DE DIMENSIUNE - pt ca pana sa adaugi un elem. trebuie sa validezi

       By tableRowsListElement = By.xpath(" //div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']");
        List<WebElement> tableRowsList = driver.findElements(tableRowsListElement);
        Assert.assertEquals(tableRowsList.size(), 3);

        By addElement = By.id("addNewRecordButton");
        elementHelper.clickJsLocator(addElement);

//completam campul first name in tab./1. ident. buton/2. specifica valoare /3. scrie valoare in tab
        By firstNameElement = By.id("firstName");
        String firstNameValue = "Iancu";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement = By.id("lastName");
        String lastNameValue = "Ana";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By userEmailElement = By.id("userEmail");
        String userEmailValue = "ianccuana@yahoo.com";
        elementHelper.fillLocator(userEmailElement, userEmailValue);

        By ageElement = By.id("age");
        String ageValue = "70";
        elementHelper.fillLocator(ageElement, ageValue);


        By salaryElement = By.id("salary");
        String salarylValue = "1000";
        elementHelper.fillLocator(salaryElement, salarylValue);

        By departmentElement = By.id("department");
        String departmentValue = "qa";
        elementHelper.fillLocator(departmentElement, departmentValue);

        By submitElements = By.id("submit");
        elementHelper.clickJsLocator(submitElements);

//        //VALIDARE CONTINUT- mai adaugam un rand/entre al 4 -lea/ dp ce am completat  randurile de maii sus 3
//        // pt a nu creea o variabila noua cu lista, stergem lista si o va folosi pe ce de mai sus si in loc de 3 e 4 si
//        //modif. mesajul cu "Valoarea actuala, nu initiala".
//
        tableRowsList = driver.findElements(tableRowsListElement);
        Assert.assertEquals(tableRowsList.size(), 4, "Valoarea actuala a tabelului nu este 4");
// M. JOS AM INLOCUIT CODUL COMENTAT DE JOS PT A FUNCTIONA INTRUCAT CONTINE SI  WAIT-UL

        elementHelper.validateTextContainsElement(tableRowsList.get(3), firstNameValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), lastNameValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), ageValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), userEmailValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), salarylValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), departmentValue);

//       String expectedRow = tableRowsList.get(3).getText();
//        Assert.assertTrue(expectedRow.contains(firstNameValue));
//        Assert.assertTrue(expectedRow.contains(lastNameValue));
//        Assert.assertTrue(expectedRow.contains(ageValue));
//        Assert.assertTrue(expectedRow.contains(userEmailValue));
//        Assert.assertTrue(expectedRow.contains(salarylValue));
//        Assert.assertTrue(expectedRow.contains(departmentValue));

        By editElement = By.id("edit-record-4");
        elementHelper.clickJsLocator(editElement);

        By editFirstNameElement = By.id("firstName");
        String editFirstNameValue = "Iancu";
//        editFirstNameElement.clear(); ???
//        editFirstNameElement.sendKeys(editFirstNameValue);

        elementHelper.clearFilledLocator(editFirstNameElement, editFirstNameValue);

//Tema de completat din nou tabelul "add" ex de la linia 30 in jos://identifica tab.add( s-a deschis tab add)
        By identificaElementAdd = By.id("addNewRecordButton");
        elementHelper.clickJsLocator(identificaElementAdd);

        //stergem apoi editam  toate campurile si incepem cu first name


        By clearEditFirstNameElement = By.id("firstName");
        String clearEditFirstNameValue = "Top";
        elementHelper.clearFilledLocator(clearEditFirstNameElement, clearEditFirstNameValue);


        By clearEditlastNameElement = By.id("lastName");
        String clearEditLastNameValue = "Vasile";
        elementHelper.clearFilledLocator(clearEditlastNameElement, clearEditLastNameValue);

        By clearEditAgeElement = By.id("age");
        String clearEditAgeValue = "50";
        elementHelper.fillLocator(clearEditAgeElement, clearEditAgeValue);

        By clearEditUserElement = By.id("userEmail");
        String clearEditUserValue = "topvasile@yahoo.com";
        elementHelper. clearFilledLocator(clearEditUserElement, clearEditUserValue);

        By clearEditSalaryElement = By.id("salary");
        String clearEditSalaryValue = "5500";
        elementHelper.clearFilledLocator(clearEditSalaryElement, clearEditSalaryValue);

        By clearEditDepartmentElement = By.id("department");
        String clearEditDepartmentValue = "qa";
        elementHelper.clearFilledLocator(clearEditDepartmentElement,  clearEditDepartmentValue);

        By clickSubmitElement = By.id("submit");
        elementHelper.clickJsLocator(clickSubmitElement);

//        //VALIDARE STERGERE CONTINUT- am copiat codul de la VALID. CONTINUT, am sters String linia 79
//        // si am adaugat clear/edit la contains.
//
//        tableRowsList = driver.findElements(By.xpath(" //div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
//        Assert.assertEquals(tableRowsList.size(),4, "Valoarea actuala a tabelului nu este 4");
//         expectedRow = tableRowsList.get(3).getText();
//        Assert.assertTrue(expectedRow.contains(clearEditFirstNameValue));
//        Assert.assertTrue(expectedRow.contains(clearEditLastNameValue));
//        Assert.assertTrue(expectedRow.contains(clearEditUserValue));
//        Assert.assertTrue(expectedRow.contains(clearEditAgeValue));
//        Assert.assertTrue(expectedRow.contains(clearEditSalaryValue));
//        Assert.assertTrue(expectedRow.contains(clearEditDepartmentValue));

        By deletElement = By.id("delete-record-5");
        elementHelper.clickJsLocator(deletElement);

        tableRowsList = driver.findElements(By.xpath(" //div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 4, "Valoarea actuala nu e 4");

    }
}
