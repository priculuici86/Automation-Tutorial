package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.util.List;

import static pageLocators.PracticFormsLocators.*;

public class PracticeFormPages {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public PracticeFormPages(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);

    }

    public void fillFirstName(String firstNameValue) {
        elementHelper.fillLocator(firstNameElement, firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        elementHelper.fillLocator(lastNameElement, lastNameValue);

    }

    public void fillEmailValue(String emailValue) {
        elementHelper.fillLocator(emailElement, emailValue);
    }

//    public void fillGenderValue(String genderValue) {
//        List<WebElement> genderOptionsList = driver.findElements(genderOptionsElement);
//        if (genderValue.equals("Male")) {
//            elementHelper.clickJsLocator(genderOptionsList.get(0));
//        }
//        if (genderValue.equals("Female")) {
//            elementHelper.clickJsLocator(genderOptionsList.get(1));
//        }
//        if (genderValue.equals("Other")) {
//            elementHelper.clickJsLocator(genderOptionsList.get(2));
//        }
//    }

    public void fillMobilePhoneValue(String mobilePhoneValue) {
        elementHelper.fillLocator(pfonNrElement, mobilePhoneValue);

    }

    public void fillSubjects(List<String> subjects) {
        elementHelper.clickJsLocator(subjectElement);

        for (int index = 0; index < subjects.size(); index++) {
            elementHelper.fillPressLocator(subjectElement, subjects.get(index), Keys.ENTER);

        }
    }

    public void fillHobbies(List<String> hobbies) {

        List<WebElement> hobbiesOptionList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index = 0; index < hobbiesOptionList.size(); index++) {
            String curentText = hobbiesOptionList.get(index).getText();
            if (hobbies.contains(curentText)) {
                elementHelper.clickJsLocator(hobbiesOptionList.get(index));
            }

        }
    }

    public void pictureUpload(String pathValue) {
        By pictureElement = By.id("uploadPicture");
        File file = new File("src/tests/resources/WP_20180504_006.jpg");
        elementHelper.fillLocator(pictureElement, file.getAbsolutePath());
    }

    public void fillCurrentAddress(String currentAddressValue) {
        elementHelper.fillLocator(currentAddressElement, currentAddressValue);
    }

    public void fillState(String stateValue) {
        elementHelper.clickJsLocator(stateElement);
        elementHelper.fillPressLocator(inputStateElement, stateValue, Keys.ENTER);
    }

    public void fillCity(String cityValue) {
        elementHelper.clickJsLocator(cityElement);
        elementHelper.fillPressLocator(cityInputElement, cityValue, Keys.ENTER);
    }

    public void clickSubmit() {
        elementHelper.clickJsLocator(submitElement);
    }

//    public void validateThankYouMessage(String expectedMessage) {
//        elementHelper.validateTextLocator(thankElement, expectedMessage);
//        System.out.println("Testul a fost validat");
//    }

//    public void validateEntireTable(String firstNameValue, String lastNameValue,
//                                    String emailValue, String genderValue, String phonNrValue,
//                                    String currentAddressValue, String stateValue, String cityValue) {
//        List<WebElement> tablesRowsList = driver.findElements(rowsListElement);
//        elementHelper.validateTextContainsElement(tablesRowsList.get(0), "Student Name");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(0), firstNameValue);
//        elementHelper.validateTextContainsElement(tablesRowsList.get(0), lastNameValue);
//
//        elementHelper.validateTextContainsElement(tablesRowsList.get(1), "Student Email");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(1), emailValue);
//
//        elementHelper.validateTextContainsElement(tablesRowsList.get(2), "Gender");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(2), genderValue);
//
//        elementHelper.validateTextContainsElement(tablesRowsList.get(3), "Mobile");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(3), phonNrValue);
//
//        elementHelper.validateTextContainsElement(tablesRowsList.get(5), "Subjects");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(5), "Maths");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(5), "Arts");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(5), "Biology");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(5), "Chemistry");
//
//        elementHelper.validateTextContainsElement(tablesRowsList.get(6), "Hobbies");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(6), "Sports");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(6), "Reading");
//
//        elementHelper.validateTextContainsElement(tablesRowsList.get(7), "Picture");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(7), "b8f4c048cdc9f521294171426cd19369.jpg");
//
//        elementHelper.validateTextContainsElement(tablesRowsList.get(8), "Address");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(8), currentAddressValue);
//
//        elementHelper.validateTextContainsElement(tablesRowsList.get(9), "State and City");
//        elementHelper.validateTextContainsElement(tablesRowsList.get(9), stateValue);
//        elementHelper.validateTextContainsElement(tablesRowsList.get(9), cityValue);
    }








