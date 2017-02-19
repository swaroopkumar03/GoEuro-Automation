package pom;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scripts.LoggingValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private List<WebElement> priceLink;

    @FindBy(xpath = "//div[@class='ResultTabs__tabIcon___wMm0I']")
    private List<WebElement> productLinks;

    public void priceSortVerification(String mode) {
        for (int i = 0; i < priceLink.size(); i++) {
            priceSortLink.click();
            String v = priceLink.get(i).getText().replace("€", "").replace(",", ".");
            Double d = Double.parseDouble(v);
            sortedPrices.add(d);
            actualPrices.add(d);
        }
        System.out.println("Number of prices displayed for " +mode + ": " +actualPrices.size());
        boolean priceSortComparisonResult = priceCheck();
        if(priceSortComparisonResult == true){
            System.out.println(mode + " Prices are sorted");
            LoggingValidation.logger = LoggingValidation.report.startTest("verifyPriceSort");
            LoggingValidation loggingValidation = new LoggingValidation();
            LoggingValidation.logger.log(LogStatus.PASS, mode+" Price Sorted");
            LoggingValidation.report.endTest(LoggingValidation.logger);
            LoggingValidation.report.flush();
        }
        else{
            LoggingValidation.logger = LoggingValidation.report.startTest("verifyPriceSort");
            LoggingValidation loggingValidation = new LoggingValidation();
            LoggingValidation.logger.log(LogStatus.FAIL, mode+"  Price  not Sorted");
            LoggingValidation.report.endTest(LoggingValidation.logger);
            LoggingValidation.report.flush();
            System.out.println(mode+ " Prices are not sorted");
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
        productLinks.get(0).click();
            priceSortVerification("Train");
    }

    public void verifyFlightPriceSort(){
        productLinks.get(1).click();
        priceSortVerification("Flight");
    }

    public void verifyBusPriceSort(){
        productLinks.get(2).click();
        priceSortVerification("Bus");
    }

}