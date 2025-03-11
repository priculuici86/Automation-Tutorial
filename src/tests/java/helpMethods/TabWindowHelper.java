package helpMethods;


import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
// Pt a customiza/reduce codul ce se repeta in mai multe clase, folosim  mostenirea
//1 Facem dp clasa o variabila noua, "driver" pt ca avem nevoie, o aducem din exterior si facem
//un constructor
public class TabWindowHelper{
    public WebDriver driver;

    public TabWindowHelper(WebDriver driver) {
        this.driver = driver;
    }
    //2 Am facut 2 metode pt a implementa codul si apela tot timpul de aici,  specific wind.tab
    public void switchToSpecificTabWindow(int index){
        List<String> tabs= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));

    }
    public void closeCurrentTabWindow(){
        driver.close();

    }

}
