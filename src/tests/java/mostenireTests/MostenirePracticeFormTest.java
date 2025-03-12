package mostenireTests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MostenirePracticeFormTest extends SharedData {


    @Test
    public void metodaTest() {


        ElementHelper elementHelper=new ElementHelper(driver);
        PageHelper pageHelper =new PageHelper(driver);

        By formsMenu = By.xpath("//h5[text()='Forms']");
        elementHelper.clickJsLocator(formsMenu);

       By practiceFormsSubmenu = By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJsLocator(practiceFormsSubmenu);

        By firstNameElement = By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = "Iancu";
        elementHelper.fillLocator(firstNameElement,firstNameValue);

        By lastNameElement = By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue = "Ana";
      elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement = By.xpath("//input[@placeholder='name@example.com']");
        String emailValue = "iancuana@yahoo.com";
        elementHelper.fillLocator(emailElement,emailValue);
/// ////////////////////////////////////////////////////////////////////////////////////////
        // E necesar sa parc. POLIMORFISMUL pt a rezolva codul m. jos

        By genderFemaleElement = By.id("gender-radio-2");
        elementHelper.clickJsLocator( genderFemaleElement);
        String genderValue = "Female";
        By genderOptionalElement = By.xpath("//input[@name='gender']");
        List<WebElement> genderOptionalList = driver.findElements(genderOptionalElement);
// !!! CAND AVEM LINIILE ALBASTRE STANGA, AC. INDICA CA SISTEMUL STIE DE O VERSIUNE A CODULUI SI SUNT MODIFICARI LA AC.
// DAND CLICK PE ALBASTRU NE ARATA CODUL  ANTERIOR SI CEL MODIFICAT, NOI PUTANT REVENI ORICAND LA CEL ANTERIOR.
// Fisierul scris cu ALBASTRU inseamna ca - Git-ul stie de ac. fisier si in el au aparut  modificari;
// Fis. cu ROSU - nu stie numica;
// Fis. cu VERDE - e nou sau la adaugat;

        if (genderValue.equals("Mail")) {
            elementHelper.clickJsLocator(genderOptionalList.get(0));
        }
        if (genderValue.equals("Femail")) {
           elementHelper.clickJsLocator(genderOptionalList.get(1));
        }

        if (genderValue.equals("Other")) {
            elementHelper.clickJsLocator(genderOptionalList.get(2));
        }
// ///////////////////////////////////////////////////////////////////////////////////////////////
        By pfonNrElement = By.xpath("//input[@placeholder='Mobile Number']");
        String pfonNrValue = "0744555256";
        elementHelper.fillLocator(pfonNrElement,pfonNrValue);
        // Cod pt scroll
        pageHelper.scrollByPixel(0,500);


// Accesam un element MULTIPLU, in care selectam un  element prin ntr-un click pe el
        By subjectElement = By.id("subjectsInput");
        elementHelper.clickJsLocator(subjectElement );
//        String subjectValue= "Arts";................
//// Aici scriem elem. in campul multiplu

        List<String> subjects = new ArrayList<>();
        subjects.add("Arts");
        subjects.add("Maths");
        subjects.add("Biology");
        subjects.add("History");
        for (int index = 0; index < subjects.size(); index++) {
//            subjectElement.sendKeys(subjects.get(index));
//            subjectElement.sendKeys(Keys.ENTER);
            elementHelper.fillPressLocator(subjectElement,subjects.get(index),Keys.ENTER);
        }
    /////////////////////////////////////////////////////////////////////////////
//Selectare optiuni hobies
// 1. Cream o lista/ multime, de Stringuri pt cele 3 optiuni music, sports..

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");
        hobbies.add("Reading");

//2. Cream o lista W.Elem. in care scriem codul elem.-lor o parcurgem cu for

        List<WebElement> hobbiesOptionList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index = 0; index < hobbiesOptionList.size(); index++) {

//3. Scoatem textul curent din lista de w.Elem. cu get si get text, punem un if/ o conditie si apoi o actiune/ click

            String curentText = hobbiesOptionList.get(index).getText();
            if (hobbies.contains(curentText)) {
                hobbiesOptionList.get(index).click();
            }
        }
        /// ///////////////////////////////////////////////////////////////////////////
        //1. Cream W.Elem. inspect/ choos file - id cod - Punem o resursa in stanga Java- resources  (copi/past)
        // dp accesam clic dreapta-path-ul, iar cu Sendkeys  met. file...d.m. jos

        By pictureElement = By.id("uploadPicture");
        File file = new File("src/tests/resources/WP_20180504_006.jpg");
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());


       By currentAddressElement = By.id("currentAddress");
        String currentAddressValue = "Arad. jud Arad";
       elementHelper.fillLocator(currentAddressElement,currentAddressValue);

// 1 .Selectam elem State
        By stateElement = By.xpath("//div[text()='Select State']");
       elementHelper.clickJsLocator(stateElement);

//2.Selectam o optiune/valoare de pe element/ NRC/ si dam ENTER
        By inputStateElement = By.id("react-select-3-input");
        String stateValue = "NCR";
//        inputStateElement.sendKeys(stateValue);
//        inputStateElement.sendKeys(Keys.ENTER);
        elementHelper.fillPressLocator(inputStateElement,stateValue, Keys.ENTER);

        //1. Alegem city
       By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJsLocator(cityElement);

        //2.
        By cityInputElement = By.id("react-select-4-input");
        String CityValue = "Delhi";
//        cityInputElement.sendKeys(CityValue);
//        cityInputElement.sendKeys(Keys.ENTER);
        elementHelper.fillPressLocator(cityElement,CityValue, Keys.ENTER);

       By submitElement = By.id("submit");
       elementHelper.clickLocator(submitElement);

//1 Accesam tab."Thanks for submitting the form" si comparam rezultatele

        By thankElement = By.id("example-modal-sizes-title-lg");

 //       PN. AICI AM LUCRAT 26.02.25 ////////////////////////////////////////////////////



        // 2 Aici in continuare trebuie sa validam expacted/actual result adica tab. cu mes."Thanks for submitting the form"
        String expectedMessage = "Thanks for submitting the form";

        //3  Aici luam textul / mesajut tab.
        String actualMessage = thankElement.getText();
        //4  Cu ac. sintaxa verificam egalitatea expected/ actual result
        Assert.assertEquals(expectedMessage, actualMessage);

        //1. Aici am luat lista cu toate R. (Ca sa comparam partea stanga tab. cu dreapta pe fiecare rand)

        List<WebElement> rowsList = driver.findElements(By.xpath("//tbody/tr"));

        Assert.assertTrue(rowsList.get(0).getText().contains("Student Name"));

        Assert.assertTrue(rowsList.get(0).getText().contains(firstNameValue));

        Assert.assertTrue(rowsList.get(0).getText().contains(lastNameValue));

        Assert.assertTrue(rowsList.get(1).getText().contains("Student Email"));
        Assert.assertTrue(rowsList.get(1).getText().contains(emailValue));

        Assert.assertTrue(rowsList.get(2).getText().contains("Gender"));
        Assert.assertTrue(rowsList.get(2).getText().contains(genderValue));

        Assert.assertTrue(rowsList.get(3).getText().contains("Mobile"));
        Assert.assertTrue(rowsList.get(3).getText().contains(pfonNrValue));


//1 Subjects, aici avem m multe stringuri/ 1r. ca sa nu scriem atata cod,
// avem nev. de o metoda sa puna toate 3 String. / 1 R , SA OBTINEM (I.A. chat GPT)MESAJ:
// "String care sa contina toate elementele din lista delimitate cu spatiu" REZ:

        String subjectStrElement = String.join(", ", subjects);
        Assert.assertTrue(rowsList.get(5).getText().contains("Subjects"));
        Assert.assertTrue(rowsList.get(5).getText().contains(subjectStrElement));

        String hobbiesOption = String.join(", ", hobbies);
        Assert.assertTrue(rowsList.get(6).getText().contains("Hobbies"));
        System.out.println(hobbiesOption);

// Verifică dacă textul din rândul 8 (indexul 7) conține cuvintele "Picture" și calea imaginii
        String rowText = rowsList.get(7).getText();
        Assert.assertTrue(rowText.contains("Picture"));
        Assert.assertTrue(rowText.contains(file.getName()));

        Assert.assertTrue(rowsList.get(8).getText().contains("Address"));
        Assert.assertTrue(rowsList.get(8).getText().contains(currentAddressValue));

        Assert.assertTrue(rowsList.get(9).getText().contains("State and City"));
        Assert.assertTrue(rowsList.get(9).getText().contains(stateValue));
        Assert.assertTrue(rowsList.get(9).getText().contains(CityValue));

    }
}
