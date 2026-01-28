package typeone.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basic {
   protected WebDriver driver;

    public Basic(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

}



