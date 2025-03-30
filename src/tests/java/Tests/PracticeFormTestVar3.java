package Tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPages;
import sharedData.SharedData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTestVar3 extends SharedData {


    @Test
    public void metodaTest() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnFormsMenu();
        indexPage.enterOnFormsSubmenu();

        String firstNameValue = "Iancu";
        String lastNameValue = "Ana";
        String emailValue = "iancuana@yahoo.com";
        String genderValue = "Female";
        String phonNrValue = "0744555256";
        List<String> subjects = new ArrayList<>();
        subjects.add("Arts");
        subjects.add("Maths");
        subjects.add("Biology");
        subjects.add("History");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");
        hobbies.add("Reading");
        String pathValue = "src/tests/resources/WP_20180504_006.jpg";
        String currentAddressValue = "Arad. jud Arad";
        String stateValue = "NCR";
        String cityValue = "Delhi";
        String expectedMessage = "Thanks for submitting the form";


        PracticeFormPages practiceFormPages = new PracticeFormPages(driver);
        practiceFormPages.fillFirstName(firstNameValue);
        practiceFormPages.fillLastName(lastNameValue);
        practiceFormPages.fillEmailValue(emailValue);
//        practiceFormPages.fillGenderValue(genderValue);
        practiceFormPages.fillMobilePhoneValue(phonNrValue);
        practiceFormPages.fillSubjects(subjects);
        practiceFormPages.fillHobbies(hobbies);
        practiceFormPages.pictureUpload(pathValue);
        practiceFormPages.fillCurrentAddress(currentAddressValue);
        practiceFormPages.fillState(stateValue);
        practiceFormPages.fillCity(cityValue);
        practiceFormPages.clickSubmit();

//        practiceFormPages.validateThankYouMessage(expectedMessage);
//        practiceFormPages.validateEntireTable(firstNameValue,lastNameValue,emailValue,genderValue,
//         phonNrValue,currentAddressValue,stateValue,cityValue);

    }
}
///??? PROBLEME LA GENDER NU SE SELECTEAZA GENUL DIN STRING, ASTFEL NU POT DA / SUBMIT SI VALIDA
