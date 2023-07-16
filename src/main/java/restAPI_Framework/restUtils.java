package restAPI_Framework;

import com.aventstack.extentreports.ExtentReports;
import freemarker.core.ReturnInstruction;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.Assert;
import reporting.extentReport;

import java.util.Map;

public class restUtils {


    private static RequestSpecification getRequestSpecification(String endPoint, Object payLoad, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(payLoad);
    }

    private static void printRequestLogReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);

        extentReport.logFailDetails("Endpoint : " + queryableRequestSpecification.getBaseUri());
        extentReport.logFailDetails("Request Method : " + queryableRequestSpecification.getMethod());
        extentReport.logFailDetails("Request Headers : " + queryableRequestSpecification.getHeaders().asList().toString());

        extentReport.logFailDetails("Request Body : ");
        extentReport.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogReport(Response response) {
        extentReport.logFailDetails("Response Status : " + response.getStatusCode());
        extentReport.logFailDetails("Response Headers : " + response.getHeaders().asList().toString());

        extentReport.logFailDetails("Response Body : ");
        extentReport.logJson(response.getBody().prettyPrint());

    }

    public static Response performPost(String endPoint, String payLoad, Map<String, String> headers) {

        RequestSpecification requestSpecification = getRequestSpecification(endPoint, payLoad, headers);

        Response response = requestSpecification.post();

        printRequestLogReport(requestSpecification);
        printResponseLogReport(response);

        return response;
    }


    //Overloaded method
    public static Response performPost(String endPoint, Map<String, Object> payLoad, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, payLoad, headers);
        Response response = requestSpecification.post();

        printRequestLogReport(requestSpecification);
        printResponseLogReport(response);

        return response;

    }


}

