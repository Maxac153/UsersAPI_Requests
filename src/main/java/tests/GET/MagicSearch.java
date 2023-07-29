package tests.GET;

import environment.environment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

@Epic("Test API method MagicSearch")
public class MagicSearch {
    private static Response responseMagicSearch(String query) {
        return given()
                .when()
                .get("magicsearch/?query=" + query);
    }

    @Feature("MagicSearch (positive)")
    @ParameterizedTest(name = "{index} => query={0}, result={2}" )
    @CsvSource(value = {
            "Ромашка| [Ромашка, Ромашка]",
    }, delimiter = '|')
    public void testMagicSearch(String query, String result) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK234());
        Response response = responseMagicSearch(query);
        response.getBody().prettyPrint();
        Assert.assertEquals(result, response.jsonPath().getString("results.name"));
    }
}
