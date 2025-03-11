package helpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageHelper {
    public WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    //1.Metoda pt scroll pagina/ si concatenam cele 2 valori sa nu le omitem- "+x+", "+y+"
public void scrollByPixel(int x, int y){
 JavascriptExecutor executor = (JavascriptExecutor) driver;
 executor.executeScript("window.scrollBy("+x+", "+y+")","" );
  }
}
