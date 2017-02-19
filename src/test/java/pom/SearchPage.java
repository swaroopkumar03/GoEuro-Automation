package pom;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import scripts.LoggingValidation;

/**
 * Created by skumar on 2/16/17.
 */
public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='from_filter']")
    private WebElement fromSearchField;

    @FindBy(xpath = "//input[@id='to_filter']")
    private WebElement toSearchField;

    @FindBy(xpath = "//input[@id='departure_date']")
    private WebElement dateField;

    @FindBy(xpath ="//input[@id='search-form__submit-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//td[@data-year]/a[.='25']")
    private WebElement selectDate;

    public void search(String from, String to){
        try {
            fromSearchField.sendKeys(from);
            toSearchField.sendKeys(to);
            dateField.click();
            Thread.sleep(5000);
            searchButton.click();
           LoggingValidation.logger = LoggingValidation.report.startTest("Search Test");
            LoggingValidation loggingValidation = new LoggingValidation();

            loggingValidation.logger.log(LogStatus.PASS,"Search Test is succcessful");

            loggingValidation.report.endTest(LoggingValidation.logger);
            loggingValidation.report.flush();
        }
        catch(Exception e){
            LoggingValidation.logger.log(LogStatus.FAIL, "Search test fail" +e.getMessage().toString());
        }
    }



}
