import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;


import java.io.IOException;

public class Methods {
    private HttpAsyncClient client = new HttpAsyncClient();
    private ObjectMapper objectMapper = new ObjectMapper();
    private String url = "https://developers.ria.com/auto/search?";
    private String api_key = "api_key=MUcjo3x6iWRA5sRPQZFzkEAFTXnT2qKPELpO8lxh";

    public HttpResponse createRequest(String params) {
        url += api_key + params;
        return client.doGetRequest(url);
    }

    public int getCountsOfResult(String body) {

        final ObjectNode node = readValueJSON(body);
        String count = node.get("result").get("search_result").get("count").asText();
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

    // Tany

    public int getCountsOfResultCommon(String body) {

        final ObjectNode node = readValueJSON(body);
        String count = node.get("result").get("search_result_common").get("count").asText();
        System.out.println(count);
        return Integer.parseInt(count);
    }
}



