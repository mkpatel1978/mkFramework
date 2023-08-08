package airlines;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

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

    public static Map<String, Object> getCreateAirlinePayloadMap() {

        Map<String, Object> payLoad = new HashMap<>();
        Faker dataFaker = new Faker();

        payLoad.put("id", dataFaker.number().digits(10));
        payLoad.put("name", dataFaker.name().firstName());
        payLoad.put("country", dataFaker.address().country());
        payLoad.put("logo", RandomStringUtils.randomAlphabetic(25));
        payLoad.put("slogan", RandomStringUtils.randomAlphabetic(20));
        payLoad.put("head_quaters", dataFaker.address().cityName());
        payLoad.put("website", "https://" + RandomStringUtils.randomAlphabetic(10) + ".com");
        payLoad.put("established", dataFaker.number().numberBetween(1900, 2020));

        return payLoad;
    }
}
