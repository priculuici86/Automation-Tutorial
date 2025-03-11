package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.List;

public class WebTableTest extends SharedData {

    @Test
public void metodaTest (){

        JavascriptExecutor executor = (JavascriptExecutor) driver;

    WebElement elementsMenu=driver.findElement(By.xpath("//h5[text()='Elements']"));
        executor.executeScript("arguments[0].click();", elementsMenu);

     WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
     executor.executeScript("arguments[0].click();", webTableSubmenu);

//VALIDARE DE DIMENSIUNE - pt ca pana sa adaugi un elem. trebuie sa validezi ca
// dimensiunea tab este  de 3 randuri/ identificam 3randuri completate intr-un tab cu 10 randuri

 List<WebElement> tableRowsList = driver.findElements(By.xpath(" //div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
   Assert.assertEquals(tableRowsList.size(), 3);

 //identificam un element/1. ident. buton/2. da click
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        executor.executeScript("arguments[0].click();", addElement);

//completam campul first name in tab./1. ident. buton/2. specifica valoare /3. scrie valoare in tab
        WebElement firstNameElement=driver.findElement(By.id("firstName"));
        String firstNameValue="Iancu";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement=driver.findElement(By.id("lastName"));
        String lastNameValue="Ana";
        lastNameElement.sendKeys (lastNameValue);

        WebElement userEmailElement=driver.findElement(By.id("userEmail"));
        String userEmailValue="ianccuana@yahoo.com";
        userEmailElement.sendKeys (userEmailValue);

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="70";
       ageElement.sendKeys (ageValue);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salarylValue="1000";
        salaryElement.sendKeys (salarylValue);

        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="qa";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElements=driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElements);
//
//        //VALIDARE CONTINUT- mai adaugam un rand/entre al 4 -lea/ dp ce am completat  randurile de maii sus 3
//        // pt a nu creea o variabila noua cu lista, stergem lista si o va folosi pe ce de mai sus si in loc de 3 e 4 si
//        //modif. mesajul cu "Valoarea actuala, nu initiala".
//
        tableRowsList = driver.findElements(By.xpath(" //div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(),4, "Valoarea actuala a tabelului nu este 4");

        String expectedRow = tableRowsList.get(3).getText();

        Assert.assertTrue(expectedRow.contains(firstNameValue));
        Assert.assertTrue(expectedRow.contains(lastNameValue));
        Assert.assertTrue(expectedRow.contains(ageValue));
        Assert.assertTrue(expectedRow.contains(userEmailValue));
        Assert.assertTrue(expectedRow.contains(salarylValue));
        Assert.assertTrue(expectedRow.contains(departmentValue));


        //editare in camp(Inspect pe creion-copiem id/parinte-nr ce vine la rand -4)
//        // pt ca s-a interceptat punem codul executor...doar linia 2, pt ca linia 1 (Javascript..)care
//        // creeaza ceva e anulata de linia 1 de la codul nostru (WebElement..ca si ea  creeaza)
//        // deci nu creeam de 2 ori
//
        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        executor.executeScript("arguments[0].click();", editElement);

        WebElement editFirstNameElement=driver.findElement(By.id("firstName"));
        String editFirstNameValue="Iancu";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

//Tema de completat din nou tabelul "add" ex de la linia 30 in jos://identifica tab.add( s-a deschis tab add)
        WebElement identificaElementAdd=driver.findElement(By.id("addNewRecordButton"));
        executor.executeScript("arguments[0].click();", identificaElementAdd);
//
        //stergem apoi editam  toate campurile si incepem cu first name


        WebElement clearEditFirstNameElement=driver.findElement(By.id("firstName"));
        clearEditFirstNameElement.clear();
        String clearEditFirstNameValue="Top";
        clearEditFirstNameElement.sendKeys(clearEditFirstNameValue);

        WebElement clearEditlastNameElement=driver.findElement(By.id("lastName"));
        clearEditlastNameElement.clear();
        String clearEditLastNameValue="Vasile";
        clearEditlastNameElement.sendKeys(clearEditLastNameValue);

        WebElement clearEditAgeElement=driver.findElement(By.id("age"));
        clearEditAgeElement.clear();
        String clearEditAgeValue= "50";
        clearEditAgeElement.sendKeys(clearEditAgeValue);

        WebElement clearEditUserElement=driver.findElement(By.id("userEmail"));
        clearEditUserElement.clear();
        String clearEditUserValue="topvasile@yahoo.com";
        clearEditUserElement.sendKeys(clearEditUserValue);

        WebElement clearEditSalaryElement=driver.findElement(By.id("salary"));
        clearEditSalaryElement.clear();
        String clearEditSalaryValue="5500";
        clearEditSalaryElement.sendKeys(clearEditSalaryValue);

        WebElement clearEditDepartmentElement=driver.findElement(By.id("department"));
        clearEditSalaryElement.clear();
        String clearEditDepartmentValue="qa";
        clearEditDepartmentElement.sendKeys(clearEditDepartmentValue);


        // La final dupa  stergere si reintroducere date, click pe submit

         WebElement clickSubmitElement=driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();",clickSubmitElement );

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

        WebElement deletElement= driver.findElement(By.id("delete-record-5"));
        executor.executeScript("arguments[0].click();", deletElement);

        tableRowsList = driver.findElements(By.xpath(" //div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 4 ,"Valoarea actuala nu e 4");

    }
}
