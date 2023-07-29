package tests.POST;

import environment.environment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.io.File;

import io.restassured.response.Response;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

@Epic("Test API method AddAvatar")
public class AddAvatar {
    private static Response responseAddAvatar(String email, String pathAvatar) {
        return given()
                .contentType("application/json")
                .multiPart("avatar", new File(pathAvatar))
                .contentType("multipart/form-data")
                .when()
                .post("addavatar?email=" + email);
    }

    @Feature("AddAvatar (positive)")
    @ParameterizedTest(name = "{index} => email={0}, pathAvatar={1}, expectedResponse={2}")
    @CsvSource({
            "verygood@mail.ru, ..\\UsersAPI_Requests\\src\\main\\java\\img\\img_8Kb.png, ok"
    })
    public void testAddImageUpload(String email, String pathAvatar, String expectedResponse) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        Response response = responseAddAvatar(email, pathAvatar);
        response.getBody().prettyPrint();
        Assert.assertEquals(expectedResponse, response.jsonPath().getString("status"));
    }

    @Feature("AddAvatar (negative)")
    @ParameterizedTest(name = "{index} => email={0}, pathAvatar={1}, expectedResponse={2}")
    @CsvSource({
            "verygood@mail.ru, ..\\UsersAPI_Requests\\src\\main\\java\\img\\img_more_150Kb.jpg, maximum file size 150kb"
    })
    public void unTestAddImageUpload(String email, String pathAvatar, String expectedResponse) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        Response response = responseAddAvatar(email, pathAvatar);
        response.getBody().prettyPrint();
        Assert.assertEquals(expectedResponse, response.jsonPath().getString("error"));
    }
}
