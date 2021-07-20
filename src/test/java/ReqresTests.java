import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqresDto.getUsers.ReqresResponse;

public class ReqresTests {

    private static final String BASE_URL = "https://reqres.in/";

    @BeforeClass
    public void configureRequestsBeforeRunningTests() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(JSON)
                .setAccept(JSON)
                .log(ALL)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(ALL)
                .build();

    }

    @Test
    public void getAllUsersByExistentPage() {
        var page = 2;
        var expectedUserId = 7;
        var expectedUserName = "Michael";
        var expectedUserSurname = "Lawson";
        var expectedEmail = "michael.lawson@reqres.in";

        var response = given()
                .when()
                .param("page", page)
                .get("api/users")
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(ReqresResponse.class);

        assertSoftly(softly -> {
            softly.assertThat(response.getPage()).as("Page number").isEqualTo(page);
            softly.assertThat(response.getData().size()).as("User list").isEqualTo(response.getPer_page());

            var actualUser = response.getData().stream().filter(user -> user.getId() == expectedUserId).findAny().get();

            softly.assertThat(actualUser.getFirst_name()).as("First name").isEqualTo(expectedUserName);
            softly.assertThat(actualUser.getLast_name()).as("Last name").isEqualTo(expectedUserSurname);
            softly.assertThat(actualUser.getEmail()).as("Email").isEqualTo(expectedEmail);
            softly.assertThat(actualUser.getAvatar()).as("Avatar").isNotBlank();

        });
    }

    @Test
    public void getAllUsersByNonExistentPage() {
        var page = 2000;

        var response = given()
                .when()
                .param("page", page)
                .get("api/users")
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(ReqresResponse.class);

        assertSoftly(softly -> {
            softly.assertThat(response.getPage()).as("Page number").isEqualTo(page);
            softly.assertThat(response.getData().size()).as("User list").isEqualTo(0);
        });
    }
}
