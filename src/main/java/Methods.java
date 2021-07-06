import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class Methods {

    private ObjectMapper objectMapper = new ObjectMapper();

    public int getCountsOfResult(String body) {

        final ObjectNode node = readValueJSON(body);
        String count = node.get("result").get("search_result").get("count").asText();
        System.out.println(count);
        return Integer.parseInt(count);
    }

    public String getQuery_String(String body) {

        final ObjectNode node = readValueJSON(body);
        return node.get("result").get("additional").get("query_string").asText();
    }

    // Tany

    public int getCountsOfResultCommon(String body) {

        final ObjectNode node = readValueJSON(body);
        String count = node.get("result").get("search_result_common").get("count").asText();
        System.out.println(count);
        return Integer.parseInt(count);
    }

    private ObjectNode readValueJSON(String body) {
        try {
            return objectMapper.readValue(body, ObjectNode.class);
        } catch (IOException e) {
            return null;
        }
    }

    public <T> T parseResponse(String response, Class<T> tClass) {
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            return objectMapper.readValue(response, tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}



