package scripts;

import org.testng.annotations.Test;
import pom.SearchResultsPage;

/**
 * Created by skumar on 2/17/17.
 */
public class SearchResultsTest extends BaseTest {

    SearchResultsPage searchResultsPage;

    @Test(priority = 1)
    public void verifyPriceForTrain() throws Exception{
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.verifyTrainPriceSort();
    }

    @Test(priority = 2)
    public void verifyPriceForFlight(){
        searchResultsPage.verifyFlightPriceSort();
    }


    @Test(priority = 3)
    public void verifyPriceForBus(){
        searchResultsPage.verifyBusPriceSort();
    }
}
