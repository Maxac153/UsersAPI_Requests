package tests.POST;


import environment.environment;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import request.RegisterData;
import request.UserData;
import response.createUser.SuccessCreateUser;
import response.doRegister.SuccessRegistration;
import response.doRegister.UnSuccessRegistration;
import specifications.Specifications;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;


public class CreateUser {
    //    @DisplayName("Test API method DoRegister (positive)")
//    @ParameterizedTest(name = "{index} => email={0}, name={1}, password={2}")
//    @CsvSource({
//            "verygood@mail.ru, Tur123, 123",
//            "vergood@mail.ru, Tur13, 1",
//    })
    @Test
    public void seccessCreateUserTest() {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        ArrayList<Integer> n1 = new ArrayList<>();
        n1.add(56);
        ArrayList<Integer> n2 = new ArrayList<>();
        n2.add(7);
        UserData user = new UserData("te342@il.com", "И64шка", n1, n2);
        SuccessCreateUser successCreateUser = given()
                .body(user)
                .when()
                .post("createuser")
                .then().log().all()
                .extract().as(SuccessCreateUser.class);

        System.out.println(successCreateUser.getDate());
    }

    @DisplayName("Test API method DoRegister (negative)")
    @ParameterizedTest(name = "{index} => email={0}, name={1}, password={2}, error_message")
    @CsvSource({
            "verygoodmail.ru, Tur123, 123, Некоректныйemailverygoodmail.ru",
            "vergood@mailru, Tur123, 123, Некоректныйemailvergood@mailru",
            "vergood@mailru, , 123, Параметрnameявляетсяобязательным!",
            "vergood@mailru, Tur123, , Параметрpasswordявляетсяобязательным!",
    })
    public void unSuccessRegTest(String email, String name, String password, String errorMessage) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        RegisterData user = new RegisterData(email, name, password);
        UnSuccessRegistration unSuccessReg = given()
                .body(user)
                .post("createuser")
                .then().log().all()
                .extract().as(UnSuccessRegistration.class);
        Assert.assertEquals("error", unSuccessReg.getType());
        Assert.assertEquals(errorMessage, unSuccessReg.getMessage().replaceAll("\\s", ""));
    }
}
