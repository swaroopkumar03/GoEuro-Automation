package pom;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static scripts.LoggingValidation.writeToReportLogging;

/**
 * Created by skumar on 2/17/17.
 */
public class SearchResultsPage extends BasePage {

    private ArrayList<Double> sortedPrices = new ArrayList<Double>();
    private ArrayList<Double> actualPrices = new ArrayList<Double>();
    @FindBy(xpath = "//span[@data-key='dw.sorting.price']")
    private WebElement priceSortLink;
    @FindBy(xpath = "//div/span[@data-test='price']")
    private List<WebElement> listOfPrices;
    @FindBy(xpath = "//div[@class='ResultTabs__tabIcon___wMm0I']")
    private List<WebElement> listOfProducts;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void priceSortVerification(String mode) {
        for (int index = 0; index < listOfPrices.size(); index++) {
            priceSortLink.click();
            String replaceSpecialCharsInPrice = listOfPrices.get(index).getText().replace("€", "").replace(",", ".");
            Double priceStringToDouble = Double.parseDouble(replaceSpecialCharsInPrice);
            sortedPrices.add(priceStringToDouble);
            actualPrices.add(priceStringToDouble);
        }
        Reporter.log("Number of prices displayed for " + mode + ": " + actualPrices.size());
        boolean priceSortComparisonResult = priceCheck();
        if (priceSortComparisonResult) {
            Reporter.log(mode + " Prices are sorted");
            writeToReportLogging("Search Test for " + mode, LogStatus.PASS, " Prices are Sorted");
        } else {
            writeToReportLogging("Search Test for " + mode, LogStatus.FAIL, " Price are not Sorted");
            Reporter.log(mode + " Prices are not sorted");
        }
        sortedPrices.clear();
        actualPrices.clear();
    }

    public boolean priceCheck() {
        Collections.sort(sortedPrices);
        if (sortedPrices.equals(actualPrices)) {
            return true;
        } else {
            return false;
        }
    }

    public void verifyTrainPriceSort() {
        listOfProducts.get(0).click();
        priceSortVerification("Train");
    }

    public void verifyFlightPriceSort() {
        listOfProducts.get(1).click();
        priceSortVerification("Flight");
    }

    public void verifyBusPriceSort() {
        listOfProducts.get(2).click();
        priceSortVerification("Bus");
    }

}