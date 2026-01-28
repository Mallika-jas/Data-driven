package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Basicc {

   protected WebDriver driver;

    public Basicc(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

}