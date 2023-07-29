package tests.DELETE;

import environment.environment;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class DeleteAvatar {
    private static Response responseDeleteImage(String email) {
        return given()
                .when()
                .delete("deleteavatar/?email=" + email);
    }

    @DisplayName("Test API method CreateCompany (positive)")
    @ParameterizedTest(name = "{index} => email={0}, status={2}")
    @CsvSource({
            "manager@mail.ru, ok",
    })
    public void testDeleteImage(String email, String expectedResponse) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        Response response = responseDeleteImage(email);
        response.getBody().prettyPrint();
        Assert.assertEquals(
                expectedResponse,
                response.jsonPath().getString("status")
        );
    }

    @DisplayName("Test API method CreateCompany (positive)")
    @ParameterizedTest(name = "{index} => email={0}, expectedResponse={2}")
    @CsvSource({
            ", Пользовательненайденcid",
    })
    public void unTestDeleteImage(String email, String expectedResponse) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        Response response = responseDeleteImage(email);
        response.getBody().prettyPrint();
        Assert.assertEquals(
                expectedResponse,
                response.jsonPath().getString("message").replaceAll(" ", "")
        );
    }
}
