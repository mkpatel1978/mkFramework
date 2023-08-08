package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Array;
import java.util.Arrays;

public class setup implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {
        String fileName = extentReport.getReportNameTimeStamp();
        String reportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;

        extentReports = extentReport.createInstance(reportPath, "Test API Report", "API Execution Report");

    }

    public void onFinish(ITestContext context) {
        if (extentReports != null)
            extentReports.flush();

    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest("Test Name : " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {

        extentReport.logFailDetails(result.getThrowable().getMessage());

        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");

        String formattedTrace = "<details>\n" +
                "<summary>Click Here for Detailed Logs</summary>\n" +
                "" + stackTrace + "\n" +
                "</details>\n";

        extentReport.logExceptionDetails(formattedTrace);

    }

}
