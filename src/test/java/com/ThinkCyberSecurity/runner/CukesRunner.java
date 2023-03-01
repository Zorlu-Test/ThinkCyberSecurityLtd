package com.ThinkCyberSecurity.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apiguardian.api.API;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources",
        glue = "com/ThinkCyberSecurity/step_Definition",
        dryRun = false,
        tags = "@UI or  @API"
)
public class CukesRunner {

}
