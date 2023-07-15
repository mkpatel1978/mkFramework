package restAPI_Framework;

import freemarker.core.ReturnInstruction;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class restUtils {
    public static Response performPost(String endPoint, String payLoad, Map<String, String> headers) {

        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(payLoad)
                .post()
                .then().log().all().extract().response();

    }
}
