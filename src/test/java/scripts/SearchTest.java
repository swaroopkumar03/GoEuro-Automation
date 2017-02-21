package scripts;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.SearchPage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by skumar on 2/16/17.
 */
public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @Parameters({"FromCity", "ToCity"})
    @Test(priority = 1)
    public void searchTest(@Optional("berlin") String from, @Optional("prague") String to) {
        searchPage = new SearchPage(driver);
        searchPage.search(from, to);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Set<String> window = driver.getWindowHandles();
        for (String windowHandle : window) {
            driver.switchTo().window(windowHandle);
        }
    }
}
