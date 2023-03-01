package com.ThinkCyberSecurity.step_Definition;

import com.ThinkCyberSecurity.pages.Pages;
import com.ThinkCyberSecurity.utilities.ConfigurationReader;
import com.ThinkCyberSecurity.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Factorial_Steps extends Pages {

    static long inputUser;

//    @Test
//    public void test1() {
//
//
//
//        getDriver().get("https://qainterview.pythonanywhere.com/");
//
//        WebElement enterInt= getDriver().findElement(By.xpath("//input[@id='number']"));
//        WebElement calculate= getDriver().findElement(By.xpath("//button[@type='submit']"));
//
//
//        enterInt.click();
//        enterInt.sendKeys("2");
//        calculate.click();
//
//
//        String formColor = enterInt.getAttribute("style");
//
//
//        Assertions.assertTrue(!formColor.toLowerCase().contains("red"),"Entered value refused");
//
//
//        // Get logs
//        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
//
//        // Iterate over the log entries and print them to the console
//        for (LogEntry entry : logs) {
//            System.out.println(entry.getLevel());
//            System.out.println(entry.getMessage());
//        }
//
//
//        try {
//            // Create a new URL object
//            URL url = new URL("https://qainterview.pythonanywhere.com/");
//
//            // Open an HTTP connection to the URL
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            // Send an HTTP GET request
//            connection.setRequestMethod("GET");
//
//            // Get the response headers
//            Map<String, List<String>> headers = connection.getHeaderFields();
//
//            // Print the headers
//            for (String key : headers.keySet()) {
//                System.out.println(key + ": " + headers.get(key));
//            }
//
//            // Disconnect the HTTP connection
//            connection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    @Given("I am on the website")
    public void iAmOnTheWebsite() {
        Driver.getDriver().get(ConfigurationReader.get("baseUrl"));
    }


    @When("I enter an invalid input {string}")
    public void iEnterAnInvalidInput(String invalidInput) {
        methods().enterInputWithClick(invalidInput);


    }

    @Then("I should see the red form validation styling")
    public void iShouldSeeTheRedFormValidationStyling() {
        methods().consoleLog();
        methods().assertionRedBorder();
    }


    @When("I input the number {int} and click on Calculate")
    public void iInputTheNumberAndClickOnCalculate(long input) {
        inputUser = input;
        methods().enterInputWithClick(Long.toString(input));
    }

    @Then("I should see the result {int}")
    public void iShouldSeeTheResult(long expectedResult) {
        methods().consoleLog();
        methods().assertions(expectedResult);
    }


    @When("I input the number {string}")
    public void iInputTheNumber(String input) {
        methods().enterInputWithClick(input);

    }

    @Then("I should see expected Result")
    public void iShouldSeeExpectedResult() {
        methods().assertions();
    }

    @When("I input  the number {int} and press enter")
    public void iInputTheNumberAndPressEnter(int input) {
        methods().enterInputWithEnter(input + "");
    }

    @Then("Verify  the number calculated")
    public void verifyTheNumberCalculated() {
        methods().assertResultDisplayed();
    }



}

