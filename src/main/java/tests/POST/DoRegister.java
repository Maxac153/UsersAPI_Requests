package tests.POST;

import environment.environment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import request.RegisterData;
import response.doRegister.UnSuccessRegistration;
import specifications.Specifications;
import org.junit.Assert;
import response.doRegister.SuccessRegistration;
import junitparams.JUnitParamsRunner;

import static io.restassured.RestAssured.given;

@RunWith(JUnitParamsRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DoRegister {

    @DisplayName("Test API method DoRegister (positive)")
    @ParameterizedTest(name = "{index} => email={0}, name={1}, password={2}")
    @CsvSource({
            "verygood@mail.ru, Tur123, 123",
            "vergood@mail.ru, Tur13, 1",
    })
    public void seccessRegTest(String email, String name, String password) {
        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        RegisterData user = new RegisterData(email, name, password);
        SuccessRegistration successRegistration = given()
                .body(user)
                .when()
                .post("doregister")
                .then().log().all()
                .extract().as(SuccessRegistration.class);

        Assert.assertEquals(name, successRegistration.getName());
        Assert.assertEquals("http://users.bugred.ru//tmp/default_avatar.jpg", successRegistration.getAvatar());
        Assert.assertEquals(0, successRegistration.getBirthday());
        Assert.assertEquals(email, successRegistration.getEmail());
        Assert.assertEquals("", successRegistration.getGender());
        Assert.assertEquals(0, successRegistration.getDate_start());
        Assert.assertEquals("", successRegistration.getHobby());
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
                .post("doregister")
                .then().log().all()
                .extract().as(UnSuccessRegistration.class);
        Assert.assertEquals("error", unSuccessReg.getType());
        Assert.assertEquals(errorMessage, unSuccessReg.getMessage().replaceAll("\\s", ""));
    }
}
