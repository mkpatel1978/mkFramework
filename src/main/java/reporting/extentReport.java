package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class extentReport {

    public static ExtentReports extentReports;

    public static ExtentReports createInstance(String fileName, String reportName, String docTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(docTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        return extentReports;
    }

    public static String getReportNameTimeStamp() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);

        String reportName = "TestReport" + formattedTime + ".html";

        return reportName;

    }

    public static void logPassDetails(String log) {
        setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFailDetails(String log) {
        setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logExceptionDetails(String log) {
        setup.extentTest.get().fail(log);
    }
    public static void logInfoDetails(String log) {
        setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.BLUE));

    }

    public static void logWarningDetails(String log) {
        setup.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));

    }

    public static void logJson(String json) {
        setup.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void logHeaders(List<Header> headersList) {
        String[][] arrayHeaders = headersList.stream().map(header -> new String[]{header.getName(), header.getValue()})
                .toArray(String[][]::new);

        setup.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
    }


}
