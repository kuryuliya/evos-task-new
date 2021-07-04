import static io.restassured.RestAssured.given;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertTrue;

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
        StringBuilder params = new StringBuilder();
        params.append("&category_id=" + category);
        params.append("&bodystyle[0]=" + bodyStyle);
        params.append("&marka_id[0]=" + marka);
        params.append("&model_id[0]=" + model);
        params.append("&s_yers[1]=" + yearsFrom);
        params.append("&po_yers[1]=" + yearsTo);
        params.append("&gearbox[1]=" + gearbox);
        params.append("&raceFrom=" + raceFrom);
        params.append("&raceTo=" + raceTo);
//        делаем запрос, получаем ответ

        String response = given()
                .when()
                .get(params.toString())
                .then()
                .statusCode(200)
                .and()
                .extract()
                .asString();

        var resultCount = page.getCountsOfResult(response);

        assertTrue(resultCount > 0, "Search returned no results, possibly incorrect search criteria");

//        Колбэк запроса, время ответа и count выводятся в консоль

    }

    @DataProvider()
    public Iterator<Object[]> getData() {
        return Stream.of(
                asList("1", "3", "47", "6", "2017", "2017", "2", "1", "1"),
                asList("1", "3", "79", "698", "2017", "2017", "1", "1", "1"),
                asList("1", "3", "28", "265", "2017", "2017", "1", "1", "1")
        ).map(List::toArray).iterator();


    }
}



