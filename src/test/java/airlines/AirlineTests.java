package airlines;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restAPI_Framework.restUtils;
import utils.jsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineTests extends AirlineAPIs{
    @Test
    public void createAirline() throws IOException {


        //    String payLoad = Payload.getCreateAirlinePayload("1111111116", "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990");

    //        Map<String, Object> payLoad = Payloads.getCreateAirlinePayloadMap("1111111135" +
    //                "10", "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990");

        Map<String, Object> payLoad = Payloads.getCreateAirlinePayloadMap();

        Response response = createAirline(payLoad);
        Assert.assertEquals(response.statusCode(), 200);

    }

}
