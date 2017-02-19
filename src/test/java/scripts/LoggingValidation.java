package scripts;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Created by skumar on 2/19/17.
 */
public class LoggingValidation {

    public static ExtentReports report = new ExtentReports("./src//Report.html", true);
    public static ExtentTest logger;
}
