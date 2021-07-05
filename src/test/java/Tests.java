import static io.restassured.RestAssured.given;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    Methods page = new Methods();

    @Test(dataProvider = "getData")
    public void searchCarsByCriteria(String model, String yearsFrom,
                                     String yearsTo) {
//        формируем критерии запроса

        var params = new HashMap<String, String>();

        params.put("model_id[0]", model);
        params.put("po_yers[1]", yearsTo);
        params.put("s_yers[1]", yearsFrom);



//        делаем запрос, получаем ответ

        String response = given()
                .when()
                .params(params)
                .get()
                .then()
                .log()
                .all()
                .statusCode(200)
                .and()
                .extract()
                .asString();

        var resultCount = page.getCountsOfResult(response);

        assertTrue(resultCount > 0, "Not found such a criteria");
    }

    /**
     * Tanya
     * input parameters String category, String bodyStyle, String marka
     *  get result.search_result_common.count - json path >0
     * */


    /**
     * Jenya
     * input parameters String model, String yearsFrom, String yearsTo
     *  get ....query_string
     *  check assertTrue(result.contains("model_id"), "Not found such a criteria");
     * */





    @DataProvider()
    public Iterator<Object[]> getData() {
        return Stream.of(
                asList( "6", "2017", "2017"),
                asList( "698", "2017", "2017"),
                asList( "265", "2017", "2017")
        ).map(List::toArray).iterator();


    }
}



