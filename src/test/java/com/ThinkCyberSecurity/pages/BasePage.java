package com.ThinkCyberSecurity.pages;

import com.ThinkCyberSecurity.utilities.Driver;
import com.ThinkCyberSecurity.utilities.ExcelUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public abstract class BasePage {

    Random random = new Random();
    public Actions actions = new Actions(Driver.getDriver());
    public Select select;
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    public Faker faker = new Faker();

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }






}
