package pom;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static scripts.LoggingValidation.writeToReportLogging;

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
            Thread.sleep(3000);
            searchButton.click();
            writeToReportLogging("Search Test", LogStatus.PASS,"Search Test is succcessful");

        }
        catch(Exception e){
            writeToReportLogging("Search Test", LogStatus.FAIL,e.getMessage().toString());
        }
    }



}
