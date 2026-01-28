package typeone.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    
	protected WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.awwwards.com/websites/green/");
    }
    public void takescreenshot(String testName) {
    	TakesScreenshot ts= (TakesScreenshot) driver; // Cast WebDriver to TakesScreenshot interface
    	
    	File src=ts.getScreenshotAs(OutputType.FILE); 	// Capture screenshot and store it temporarily as a file
    	String timeStamp=new SimpleDateFormat("yyyyMMDD-HHmmss").format(new Date());	// Create timestamp to avoid overwriting screenshots
    	
    	String path= System.getProperty("user.dir")+"/screenshots/" + testName + "_" + timeStamp + ".png";	// Create full path where screenshot will be saved
    	
    	try {
    	FileUtils.copyFile(src, new File(path));	// Copy screenshot from temp location to project folder
    	System.out.println("screenshot saved"+ path);		// Print screenshot location in console
    	}catch(IOException e) {	// Handle file-related errors
    		e.printStackTrace();
    	}
    	
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}