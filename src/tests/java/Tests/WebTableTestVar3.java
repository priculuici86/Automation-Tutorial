package Tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablesPages;
import sharedData.SharedData;

import java.util.List;

public class WebTableTestVar3 extends SharedData {

    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.elementsMenu();
        indexPage.webTableSubmenu();

        ElementHelper elementHelper = new ElementHelper(driver);
        WebTablesPages webTablesPages = new WebTablesPages(driver);

        webTablesPages.verifyTableContent(3);
        webTablesPages.addNewRecordButtonClick();


        String firstNameValue = "Iancu";
        String lastNameValue = "Ana";
        String userEmailValue = "ianccuana@yahoo.com";
        String ageValue = "70";
        String salarylValue = "1000";
        String departmentValue = "qa";
        int expectedSize = 4;

        webTablesPages.fillFirstName(firstNameValue);
        webTablesPages.fillLastName(lastNameValue);
        webTablesPages.fillEmail(userEmailValue);
        webTablesPages.fillAge(ageValue);
        webTablesPages.fillSalary(salarylValue);
        webTablesPages.fillDepartment(departmentValue);
        webTablesPages.submitClick();


        webTablesPages.verifyTableContent(expectedSize, firstNameValue, lastNameValue, userEmailValue,
                ageValue, salarylValue, departmentValue);

//        webTablesPages.clearText(firstNameValue);
        webTablesPages.editClick();

        String firstNameValueEdit = "Ran";
        String lastNameValueEdit = "Ghesa";
        String userEmailValueEdit = "razn@gmail.com";
        String ageValueEdit = "5";
        String salaryValueEdit = "300";
        String departmentValueEdit = "ijjt";
        int expectedSizeEdit = 4;

        webTablesPages.verifyTableContent(expectedSizeEdit);
        webTablesPages.fillFirstName(firstNameValueEdit);
        webTablesPages.fillLastName (lastNameValueEdit);
        webTablesPages.fillEmail(userEmailValueEdit);
        webTablesPages.fillAge(ageValueEdit);
        webTablesPages.fillSalary(salaryValueEdit);
        webTablesPages.fillDepartment(departmentValueEdit);
        webTablesPages.submitClick();

        webTablesPages.deleteRecords();

        webTablesPages.verifyTableContent(3);

   }
}
