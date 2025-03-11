package teme;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tema1EmagTestAna {

   public WebDriver driver;

   @Test
  public void metodaTestEmag(){

       // deschidem un browser gol
      driver=new ChromeDriver();

       //accesam o pagina web/ Emag
      driver.get("https://www.emag.ro/laptop-tablete-telefoane/d?ref=hdr_menu_department_1 ");

      //facem browserul in modul maximaze

       driver.manage().window().maximize();



   }
}
