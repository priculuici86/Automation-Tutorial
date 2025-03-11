package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void metodaTest() {


        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        executor.executeScript("arguments[0].click();", formsMenu);

        WebElement practiceFormsMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        executor.executeScript("arguments[0].click();", practiceFormsMenu);

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Iancu";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Ana";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        String emailValue = "iancuana@yahoo.com";
        emailElement.sendKeys(emailValue);

//Varianta personalizata gender- female CURS 9/ 06.02.2025

        WebElement genderFemaleElement = driver.findElement(By.id("gender-radio-2"));
        executor.executeScript("arguments[0].click();", genderFemaleElement);


//  Varianta universala gender
//  In String stabilim val.ce o vrem accesata
        String genderValue = "Female";

//  Aici salvam lista de otiuni gender
        List<WebElement> genderOptionalList = driver.findElements(By.xpath("//input[@name='gender']"));

// Aici folosim o alternativa if/sweche pt ca in cazul in care mai apar optiuni pe viitor sa le putem include
// ca var. universal valabila, doar specificam in Srting ce opt.  vrem.
//  Sub if e linia care face click pe elementul specificat in String.
        if (genderValue.equals("Mail")) {
            executor.executeScript("arguments[0].click();", genderOptionalList.get(0));
        }
        if (genderValue.equals("Femail")) {
            executor.executeScript("arguments[0].click();", genderOptionalList.get(1));
        }

        if (genderValue.equals("Other")) {
            executor.executeScript("arguments[0].click();", genderOptionalList.get(2));
        }
// introd.nr telefon
        WebElement pfonNrElement = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        String pfonNrValue = "0744555256";
        pfonNrElement.sendKeys(pfonNrValue);

        executor.executeScript("window.scrollBy(0,500)", "");

// Accesam un element MULTIPLU, in care selectam un  element prin ntr-un click pe el
        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        executor.executeScript("arguments[0].click();", subjectElement);

//        String subjectValue= "Arts";................
//// Aici scriem elem. in campul multiplu
//        subjectElement.sendKeys(subjectValue);........
// Ca sa apesi o comanda de la tastatura "enter" aici, pt a insera elem in camp si obtine codul in cosola
//pt ca "inspect" nu putem accesa

//        subjectElement.sendKeys(Keys.ENTER);
//
//        String subjectValue2= "Mats";
//        subjectElement.sendKeys(subjectValue2);
//        subjectElement.sendKeys(Keys.ENTER);

// Pt eficientizare cod creez o lista de Stringuri in care introduc  1 sau m multe elemente ce le
// vreau selectate, parcurg lista cu un for, iar in interiorul for-ului voi completa  pe rand fiecare val.
// in subjectElement dupa apas ENTER


        List<String> subjects = new ArrayList<>();
        subjects.add("Arts");
        subjects.add("Maths");
        subjects.add("Biology");
        subjects.add("History");
        for (int index = 0; index < subjects.size(); index++) {
            subjectElement.sendKeys(subjects.get(index));
            subjectElement.sendKeys(Keys.ENTER);
        }
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
        //1. Cream W.Elem. inspect/ choos file - id cod - Punem o resursa in stanga Java- resources  (copi/past)
        // dp accesam clic dreapta-path-ul, iar cu Sendkeys  met. file...d.m. jos

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/tests/resources/WP_20180504_006.jpg");
        pictureElement.sendKeys(file.getAbsolutePath());


        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Arad. jud Arad";
        currentAddressElement.sendKeys(currentAddressValue);

// 1 .Selectam elem State
        WebElement stateElement = driver.findElement(By.xpath("//div[text()='Select State']"));
        executor.executeScript("arguments[0].click();", stateElement);

//2.Selectam o optiune/valoare de pe element/ NRC/ si dam ENTER
        WebElement inputStateElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        inputStateElement.sendKeys(stateValue);
        inputStateElement.sendKeys(Keys.ENTER);

        //1. Alegem city
        WebElement cityElement = driver.findElement(By.xpath("//div[text()='Select City']"));
        executor.executeScript("arguments[0].click();", cityElement);

        //2.
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String CityValue = "Delhi";
        cityInputElement.sendKeys(CityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

//1 Accesam tab."Thanks for submitting the form" si comparam rezultatele

        WebElement thankElement = driver.findElement(By.id("example-modal-sizes-title-lg"));

        // 2 Aici in continuare trebuie sa validam expacted/actual result adica tab. cu mes."Thanks for submitting the form"
        String expectedMessage = "Thanks for submitting the form";

        //3  Aici luam textul / mesajut teb.
        String actualMessage = thankElement.getText();
//4  Cu ac. sintaxa verificam egalitatea expected/ actual result
        Assert.assertEquals(expectedMessage, actualMessage);

//1. Aici am luat lista cu toate R. (Ca sa comparam partea stanga tab. cu dreapta pe fiecare rand)

        List<WebElement> rowsList = driver.findElements(By.xpath("//tbody/tr"));

//   Aici vreau primul elem /R. din lista, fiindca compara stanga cu dreapta tab si nu-s = folosim
//  "assert True", validam ca primul Rand contine numele intr. /prenumele etc
//Pt r1 stang
        Assert.assertTrue(rowsList.get(0).getText().contains("Student Name"));
// Pt r1 dreapta  first name
        Assert.assertTrue(rowsList.get(0).getText().contains(firstNameValue));
//Pt. R1 dreapta Last name
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

//4. Verificarea cu Assert.assertTrue
//Dacă textul din rowsList.get(6) conține "Hobbies", dar nu conține exact lista hobbiesOption, atunci unul dintre aserțiuni va eșua.
//Posibile soluții:
//Folosește System.out.println(hobbiesOption) pentru a te asigura că hobbiesOption este corect construit.
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
