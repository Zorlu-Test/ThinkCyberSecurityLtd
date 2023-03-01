package com.ThinkCyberSecurity.pages;

import com.ThinkCyberSecurity.utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.regex.Pattern;

import static com.ThinkCyberSecurity.utilities.Driver.getDriver;

public class Methods extends Pages {


    public static double calculateFactorial(double n) {

        double factorialNum = 1;

        for (int i = 1; i <= n; i++) {
            factorialNum = factorialNum * i;
        }


        return factorialNum;
    }


    public static void assertionFactorial(long enteredValue, long actualResult) {
        Assertions.assertEquals(calculateFactorial(enteredValue), actualResult, "Number does not match!");
    }

    public void assertionRedBorder() {
        String style = dashBoard().enterInt.getAttribute("style");

        if (!style.equalsIgnoreCase("border: 2px solid red;")) {
            Assertions.fail("Border is not red");
        }

    }

    public void enterInputWithClick(String input) {
        dashBoard().enterInt.click();
        dashBoard().enterInt.sendKeys(input);
        dashBoard().calculate.click();

    }

    public void enterInputWithEnter(String  input) {
        dashBoard().enterInt.click();
        dashBoard().enterInt.sendKeys(input+"", Keys.ENTER);

    }

    public void assertions() {

        String pattern = "The factorial of";
        dashBoard().wait.until(ExpectedConditions.textMatches(By.id("resultDiv"), Pattern.compile(pattern)));


        String[] s = dashBoard().result.getText().split(" ");


        String userInput = s[3];
        double actualResult = Double.parseDouble(s[5]) ;
        double expectedResultDouble = calculateFactorial(Double.parseDouble(userInput));


        Assertions.assertEquals(expectedResultDouble, actualResult, "Factorial Assertion Error!");

    }


    public void assertResultDisplayed(){
        String pattern = "The factorial of";
        dashBoard().wait.until(ExpectedConditions.textMatches(By.id("resultDiv"), Pattern.compile(pattern)));

        String result=dashBoard().result.getText();
        System.out.println("result = " + result);

        Assertions.assertTrue(!result.equals(""));


    }


    public void assertions(long expectedResultCucumber) {

        String pattern = "The factorial of";
        dashBoard().wait.until(ExpectedConditions.textMatches(By.id("resultDiv"), Pattern.compile(pattern)));


        String[] s = dashBoard().result.getText().split(" ");


        long actualResult = Long.parseLong(s[5]);
        long expectedResult = expectedResultCucumber;


        Assertions.assertEquals(expectedResult, actualResult, "Factorial Assertion Error!");


    }


    public void consoleLog() {
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);

        // Iterate over the log entries and print them to the console
        for (LogEntry entry : logs) {


            System.out.println("Severity level = " + entry.getLevel());
            System.out.println("Console message = " + entry.getMessage());
        }

    }


}
