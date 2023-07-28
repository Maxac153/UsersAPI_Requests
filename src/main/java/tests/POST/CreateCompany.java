package tests.POST;

import environment.environment;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import request.CompanyData;
import response.createCompany.SuccessCreateCompany;
import response.createCompany.UnSuccessCreateCompany;
import specifications.Specifications;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateCompany {
    @DisplayName("Test API method CreateCompany (positive)")
    @ParameterizedTest(name = "{index} => company_name={0}, company_type={1}, company_users={2}, email_owner={3}, error_message={4}")
    @CsvSource({
            "Алкоголики и тунедцы, ООО, verygood@mail.ru, aa+1@mail.com",
    })
    public void seccessCreateCompanyTest(String company_name, String company_type, String users, String email_owner) {
        ArrayList<String> company_users = new ArrayList<>();
        company_users.add(users);

        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        CompanyData user = new CompanyData(company_name, company_type, company_users, email_owner);
        SuccessCreateCompany successCreateCompany = given()
                .body(user)
                .when()
                .post("createcompany")
                .then().log().all()
                .extract().as(SuccessCreateCompany.class);

        Assert.assertEquals(company_name, successCreateCompany.getCompany().getName());
        Assert.assertEquals(company_type, successCreateCompany.getCompany().getType());
    }

    @DisplayName("Test API method CreateCompany (negative)")
    @ParameterizedTest(name = "{index} => type={0}, message={1}")
    @CsvSource({
            ", ООО, verygood@mail.ru, aa+1@mail.com, Параметр company_name является обязательным!",
            "Алкоголики и тунедцы, , verygood@mail.ru, aa+1@mail.com, Параметр company_type является обязательным!",
            "Алкоголики и тунедцы, ООО, , aa+1@mail.com, company_users  не указаны сотрудники",
            "Алкоголики и тунедцы, ООО, verygood@mail.ru, , Параметр email_owner является обязательным!",
    })
    public void unSuccessCreateCompanyTest(String company_name, String company_type, String users, String email_owner, String error_message) {
        ArrayList<String> company_users = new ArrayList<>();
        company_users.add(users);

        Specifications.installSpecification(Specifications.requestSpec(environment.URL), Specifications.responseSpecOK200());
        CompanyData user = new CompanyData(company_name, company_type, company_users, email_owner);
        UnSuccessCreateCompany unSuccessCreateCompany = given()
                .body(user)
                .when()
                .post("createcompany")
                .then().log().all()
                .extract().as(UnSuccessCreateCompany.class);

        Assert.assertEquals("error", unSuccessCreateCompany.getType());
        Assert.assertEquals(error_message, unSuccessCreateCompany.getMessage());
    }
}