package airlines;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Payloads {

    public static String getCreateAirlinePayload(String id, String name, String country, String logo, String slogan, String head_quarters, String website, String established) {
        String payLoad = "{\n" +
                "    \"id\": " + id + ",\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"country\": \"" + country + "\",\n" +
                "    \"logo\": \"" + logo + "\",\n" +
                "    \"slogan\": \"" + slogan + "\",\n" +
                "    \"head_quaters\": \"" + head_quarters + "\",\n" +
                "    \"website\": \"" + website + "\",\n" +
                "    \"established\": \"" + established + "\"\n" +
                "}";
        return payLoad;
    }

    public static Map<String, Object> getCreateAirlinePayloadMap(String id, String name, String country, String logo, String slogan, String head_quarters, String website, String established) {

        Map<String, Object> payLoad = new HashMap<>();

        payLoad.put("id", id);
        payLoad.put("name", name);
        payLoad.put("country", country);
        payLoad.put("logo", logo);
        payLoad.put("slogan", slogan);
        payLoad.put("head_quaters", head_quarters);
        payLoad.put("website", website);
        payLoad.put("established", established);

        return payLoad;
    }
}
