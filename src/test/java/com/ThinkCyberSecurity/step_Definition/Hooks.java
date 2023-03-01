package com.ThinkCyberSecurity.step_Definition;


import com.ThinkCyberSecurity.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static io.restassured.RestAssured.baseURI;

public class Hooks {


    @Before(value = "@API")
    public void sutUP() {
        baseURI = "http://qainterview.pythonanywhere.com/factorial";

    }


    @After(value = "@IU")
    public void tearDown(Scenario scenario) throws InterruptedException {

        Thread.sleep(400);

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();
    }


}
