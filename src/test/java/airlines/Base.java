package airlines;

import utils.jsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {
    public static Map<String, Object> dataFromJsonFile;

    static {
        System.out.println(System.getProperty("env") + " Environment");

        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        try {
            dataFromJsonFile = jsonUtils.getJsonDataMap(env + "/airlinesAPIDataQA.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
