package com.ThinkCyberSecurity.step_Definition;

import com.ThinkCyberSecurity.pages.Methods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class Api_Factorial_Steps {


    static int inputUser;
    Response response;


    @Given("I post the number {string}")
    public void iPostTheNumber(String input) {
        inputUser = Integer.parseInt(input);

        response = given()
                .accept(ContentType.JSON)
                .multiPart("number", input)
                .when()
                .post(baseURI)
                .then()
                .extract().response();
    }


    @Then("Verify  status code should be {int}")
    public void verifyStatusCodeShouldBe(int statusCode) {

        response.then().statusCode(statusCode);
        response.then().log().all();

    }

    @And("The response content type should be {string}")
    public void theResponseContentTypeShouldBe(String contentType) {

        response.then().header("Content-Type", contentType);

    }

    @And("Respond body answer expected result")
    public void respondBodyAnswerExpectedResult() {
        double actual = response.jsonPath().getDouble("answer");
        double expected = Methods.calculateFactorial(inputUser);


        Assertions.assertEquals(actual,expected);

    }

    @And("The header contains date")
    public void theHeaderContainsDate() {

        response.then().header("Date",is(notNullValue()));



    }



}
