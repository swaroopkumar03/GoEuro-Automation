package scripts;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Reporter;

/**
 * Created by skumar on 2/19/17.
 */
public class LoggingValidation {

    public static ExtentReports report = new ExtentReports("./src//Report.html", true);
    public static ExtentTest logger;

    public static void writeToReportLogging(String logTestName,LogStatus logStatus,String logTestResult){
        LoggingValidation.logger = LoggingValidation.report.startTest(logTestName);
        LoggingValidation.logger.log(logStatus,logTestResult);
        LoggingValidation.report.endTest(LoggingValidation.logger);
        LoggingValidation.report.flush();
    }

    public static void writeToReportLogging(String logTestName,LogStatus logStatus,String logTestResult,String mode){
        Reporter.log(mode + " Prices are sorted");
        LoggingValidation.logger = LoggingValidation.report.startTest(logTestName +mode);
        LoggingValidation.logger.log(logStatus, mode+logTestResult);
        LoggingValidation.report.endTest(LoggingValidation.logger);
        LoggingValidation.report.flush();

    }
}
