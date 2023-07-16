package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class jsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> getJsonDataMap(String jsonFileName) throws IOException {
        String jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        Map<String, Object> data = (Map<String, Object>) objectMapper.readValue(new File(jsonFilePath), new TypeReference<Object>() {});

        return data;

    }

}
