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

    @FindBy(xpath = "(//input[@id='$city'])[1]")
    private WebElement departureCity;
    @FindBy(xpath = "(//input[@id='$city'])[2]")
    private WebElement arrivalCity;
    @FindBy(xpath = "//div[@class='sb-field']")
    private WebElement dateField;
    @FindBy(xpath = "//td[@data-year]/a[.='25']")
    private WebElement selectDate;
    @FindBy(xpath = "//button[@id='dLsbSubmit']")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String from, String to) {
        try {
            departureCity.sendKeys(from);
            Thread.sleep(2000);
            arrivalCity.sendKeys(to);
            Thread.sleep(2000);
            dateField.click();
            Thread.sleep(3000);
            searchButton.click();
            writeToReportLogging("Search Test", LogStatus.PASS, "Search Test is succcessful");

        } catch (Exception e) {
            writeToReportLogging("Search Test", LogStatus.FAIL, e.getMessage());
        }
    }
}
