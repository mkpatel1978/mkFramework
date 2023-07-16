package airlines;

import io.restassured.response.Response;
import restAPI_Framework.restUtils;
import utils.jsonUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirline(Map<String, Object> createAirlinePayload) {
        String endPoint = (String) Base.dataFromJsonFile.get("createAirlineEndpoint");

        return restUtils.performPost(endPoint,createAirlinePayload,new HashMap<>());

    }
}
