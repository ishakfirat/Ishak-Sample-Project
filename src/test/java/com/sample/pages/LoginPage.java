package com.sample.pages;

import com.sample.utilities.ConfigurationReader;
import com.sample.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "_username")
    public WebElement inputUsername;

    @FindBy(name = "_password")
    public WebElement inputPassword;

    @FindBy(name = "_submit")
    public WebElement loginBtn;

    @FindBy(xpath = "//h2[.='Login']")
    public WebElement loginHeader;

    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();

    }


/*
    public void loginWithUsername(String userType){
        String username="";
        String password="";

        if (userType.equalsIgnoreCase("Driver")){
            username= ConfigurationReader.getProperty("driver.username");
            password= ConfigurationReader.getProperty("driver.password");

        } else if (userType.equalsIgnoreCase("Sales Manager")) {
            username = ConfigurationReader.getProperty("salesmanager.username");
            password = ConfigurationReader.getProperty("salesmanager.password");


        }else {
            username = ConfigurationReader.getProperty("storemanager.username");
            password = ConfigurationReader.getProperty("storemanager.password");
        }

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();



    }

 */









}
