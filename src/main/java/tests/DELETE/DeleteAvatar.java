package tests.DELETE;

import environment.environment;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class DeleteAvatar {
    @Test
    public void testDeleteImage() {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        Response response = given()
                .when()
                .delete("deleteavatar/?email=verygood@mail.ru");
        response.getBody().prettyPrint();
    }
}
