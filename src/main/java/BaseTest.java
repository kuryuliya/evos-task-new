import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private final static String BASE_URI = "https://developers.ria.com/auto/search?";
    private String API_KEY_HEADER = "api_key=MUcjo3x6iWRA5sRPQZFzkEAFTXnT2qKPELpO8lxh";
    private String API_KEY_VALUE = "api_key=MUcjo3x6iWRA5sRPQZFzkEAFTXnT2qKPELpO8lxh";

    @BeforeClass
    public void configureRequestsBeforeRunningTests() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addFormParam(API_KEY_HEADER, API_KEY_VALUE)
                .setContentType(JSON)
                .setAccept(JSON)
                .log(ALL)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(ALL)
                .build();

    }
}
