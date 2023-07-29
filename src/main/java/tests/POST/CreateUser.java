package tests.POST;


import environment.environment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import request.UserData;
import response.createUser.SuccessCreateUser;
import response.createUser.UnSuccessCreateUser;
import specifications.Specifications;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;


@Epic("Test API method CreateUser")
public class CreateUser {

    @Feature("CreateUser (positive)")
    @ParameterizedTest(name = "{index} => email={0}, name={1}")
    @CsvSource({
            "te1233@il.com, И6sdf4ша"
    })
    public void successCreateUserTest(String email, String name) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        ArrayList<Integer> n1 = new ArrayList<>();
        n1.add(20);
        ArrayList<Integer> n2 = new ArrayList<>();
        n2.add(19);
        UserData user = new UserData(email, name, n1, n2);
        SuccessCreateUser successCreateUser = given()
                .body(user)
                .when()
                .post("createuser")
                .then().log().all()
                .extract().as(SuccessCreateUser.class);

        Assert.assertEquals(email, successCreateUser.getEmail());
        Assert.assertEquals(name, successCreateUser.getName());
    }


    @Feature("CreateUser (negative)")
    @ParameterizedTest(name = "{index} => email={0}, name={1}, error_message={2}")
    @CsvSource({
            "verygoodmail.ru, Tur123,  email неправильный!",
            "vergood@mailru, Tur123, email неправильный!",
            "vergood@mailru, , Параметр name является обязательным!"
    })
    public void unSuccessCreateUserTest(String email, String name, String errorMessage) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        ArrayList<Integer> n1 = new ArrayList<>();
        n1.add(20);
        ArrayList<Integer> n2 = new ArrayList<>();
        n2.add(19);
        UserData user = new UserData(email, name, n1, n2);
        UnSuccessCreateUser unSuccessReg = given()
                .body(user)
                .post("createuser")
                .then().log().all()
                .extract().as(UnSuccessCreateUser.class);

        Assert.assertEquals("error", unSuccessReg.getType());
        Assert.assertEquals(errorMessage, unSuccessReg.getMessage());
    }
}
