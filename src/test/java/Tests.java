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
    public void searchCarsByCriteria(String category, String bodyStyle, String marka, String model, String yearsFrom,
                                     String yearsTo, String gearbox, String raceFrom, String raceTo) {
//        формируем критерии запроса

        var params = new HashMap<String, String>();
        params.put("category_id", category);
        params.put("bodystyle[0]", bodyStyle);
        params.put("marka_id[0]", marka);
        params.put("model_id[0]", model);
        params.put("po_yers[1]", yearsTo);
        params.put("s_yers[1]", yearsFrom);
        params.put("gearbox[1]", gearbox);
        params.put("raceFrom", raceFrom);
//        params.put("raceTo", raceTo);


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

        assertTrue(resultCount > 0, "Search returned no results, possibly incorrect search criteria");
    }
    @DataProvider()
    public Iterator<Object[]> getData() {
        return Stream.of(
                asList("1", "3", "47", "6", "2017", "2017", "2", "1", "1"),
                asList("1", "3", "79", "698", "2017", "2017", "1", "1", "1"),
                asList("1", "3", "28", "265", "2017", "2017", "1", "1", "1")
        ).map(List::toArray).iterator();


    }

    /**
     * Tanya
     * input parameters String category, String bodyStyle, String marka
     *  get result.search_result_common.count - json path >0
     * */
    @Test(dataProvider = "getDataCount")
    public void searchCars(String category, String bodyStyle, String marka) {
//        формируем критерии запроса

        var params = new HashMap<String, String>();
        params.put("category_id", category);
        params.put("bodystyle[0]", bodyStyle);
        params.put("marka_id[0]", marka);


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

        var resultCommonCount = page.getCountsOfResultCommon(response);

        assertTrue(resultCommonCount > 0, "Search returned no results, possibly incorrect search criteria");
    }
    @DataProvider()
    public Iterator<Object[]> getDataCount() {
        return Stream.of(
                asList("1", "3", "47"),
                asList("1", "3", "79"),
                asList("1", "3", "28")
        ).map(List::toArray).iterator();


    }
    /**
     * Jenya
     * input parameters String model, String yearsFrom, String yearsTo
     *  get ....query_string
     *  check assertTrue(result.contains("model_id"), "Not found such a criteria");
     * */


}



