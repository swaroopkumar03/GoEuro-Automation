package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Created by skumar on 2/16/17.
 */
public class BaseTest {

    public static WebDriver driver;
    //public static ExtentReports extentReports;
    //LoggingValidation loggingValidation;

    @Parameters({"url"})
    @BeforeTest
    public void preCondition(@Optional("http://www.goeuro.es/") String url)
    {
        driver=new FirefoxDriver();
        driver.get(url);
    }

    @AfterTest
    public void postCondition(){
        driver.quit();
    }

}