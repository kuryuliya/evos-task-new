import static io.restassured.RestAssured.given;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertTrue;

import dto.SearchResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
     * Tanya input parameters String category, String bodyStyle, String marka get result.search_result_common.count -
     * json path >0
     */
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
     * Jenya input parameters String model, String yearsFrom, String yearsTo get ....query_string check
     * assertTrue(result.contains("model_id"), "Not found such a criteria");
     */

    @Test(dataProvider = "getDataModelYear")
    public void searchCarsByCriteriaModelYear(String model, String yearsFrom,
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

        var query_String = page.getQuery_String(response);

        assertTrue(query_String.contains("model_id"), "Not found such a criteria");
    }

    @DataProvider()
    public Iterator<Object[]> getDataModelYear() {
        return Stream.of(
                asList("6", "2017", "2017"),
                asList("698", "2017", "2017"),
                asList("265", "2017", "2017")
        ).map(List::toArray).iterator();


    }

    @Test
    public void searchCarsByYear() {
//        формируем критерии запроса
        var params = Map.of(
                "po_yers[1]", "2017",
                "s_yers[1]", "2017",
                "category_id", "1",
                "bodystyle[0]", "3",
                "bodystyle[1]", "5");

//        делаем запрос, получаем ответ
        var response = given()
                .when()
                .params(params)
                .get()
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .body()
                .asString();

        var getResponseAsClass = page.parseResponse(response, SearchResponse.class);
        var carList =  getResponseAsClass.getResult().getSearch_result_common().getData();

        assertTrue(carList.stream().allMatch(car -> car.getType().equals("UsedAuto")), "Was found a car with another type(not 'UsedAuto')");
    }

    /**
     * Для Тани
     * создать такой же тест, как searchCarsByYear()
     * постараться разобраться, что там происходит
     * строку var carList =  getResponseAsClass.getResult().getSearch_result_common().getData(); заменить на свою, где нужно будет получить List по пути
     * additional.search_params.all.bodystyle
     * почитать что такое Stream() и какие у него есть методы
     * далее заменить проверку на свою, где нужно будет проверить что список bodystyle имеет всего два элемента(
     * метод size()), поменять нужно только это вырежение для этого carList.stream().allMatch(car -> car.getType().equals("UsedAuto")
     * */

    /**
     * Для Жени
     * создать такой же тест, как searchCarsByYear()
     * постараться разобраться, что там происходит
     * строку var carList =  getResponseAsClass.getResult().getSearch_result_common().getData(); заменить на свою, где нужно будет получить List по пути
     * result.search_result.ids
     * почитать что такое Stream() и какие у него есть методы
     * далее заменить проверку на свою, где нужно будет проверить что каждый элементы из списка ids не пустой(
     * метод isEmpty()), поменять нужно только это вырежение для этого carList.stream().allMatch(car -> car.getType().equals("UsedAuto")
     * */
}



