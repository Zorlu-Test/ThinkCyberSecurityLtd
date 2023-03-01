package com.ThinkCyberSecurity.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoard extends BasePage {


    @FindBy(xpath = "//input[@id='number']")
    public WebElement enterInt;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement calculate;

    @FindBy(xpath = "//div/p[@id='resultDiv']")
    public WebElement result;

    @FindBy(xpath = "//span[@class='input-group-addon']")
    public WebElement arrow;


}
