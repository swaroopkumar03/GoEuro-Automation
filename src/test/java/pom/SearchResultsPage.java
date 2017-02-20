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

import static scripts.LoggingValidation.logger;
import static scripts.LoggingValidation.report;

/**
 * Created by skumar on 2/17/17.
 */
public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    ArrayList<Double> sortedPrices = new ArrayList<Double>();
    ArrayList<Double> actualPrices = new ArrayList<Double>();

    @FindBy(xpath = "//span[@data-key='dw.sorting.price']")
    private WebElement priceSortLink;

    @FindBy(xpath = "//div/span[@data-test='price']")
    private List<WebElement> listOfPrices;

    @FindBy(xpath = "//div[@class='ResultTabs__tabIcon___wMm0I']")
    private List<WebElement> listOfProducts;

    public void priceSortVerification(String mode) {
        for (int i = 0; i < listOfPrices.size(); i++) {
            priceSortLink.click();
            String replaceSpecialCharsInPrice = listOfPrices.get(i).getText().replace("€", "").replace(",", ".");
            Double priceStringToDouble = Double.parseDouble(replaceSpecialCharsInPrice);
            sortedPrices.add(priceStringToDouble);
            actualPrices.add(priceStringToDouble);
        }
        Reporter.log("Number of prices displayed for " + mode + ": " +actualPrices.size());
        boolean priceSortComparisonResult = priceCheck();
        if(priceSortComparisonResult == true){
            Reporter.log(mode + " Prices are sorted");
            logger = report.startTest("Verify Price Sort for : " +mode);
            logger.log(LogStatus.PASS, mode+" Price Sorted");
            report.endTest(logger);
            report.flush();
        }
        else{
            logger = report.startTest("Verify Price Sort : " +mode);
            logger.log(LogStatus.FAIL, mode+"  Price  not Sorted");
            report.endTest(logger);
            report.flush();
            Reporter.log(mode+ " Prices are not sorted");
    }
        sortedPrices.clear();
        actualPrices.clear();
    }

    public boolean priceCheck(){
        Collections.sort(sortedPrices);
        if (sortedPrices.equals(actualPrices)) {
            return true;
        } else {
            return false;
        }
    }

    public void verifyTrainPriceSort(){
        listOfProducts.get(0).click();
            priceSortVerification("Train");
    }

    public void verifyFlightPriceSort(){
        listOfProducts.get(1).click();
        priceSortVerification("Flight");
    }

    public void verifyBusPriceSort(){
        listOfProducts.get(2).click();
        priceSortVerification("Bus");
    }

}