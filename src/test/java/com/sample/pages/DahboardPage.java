package com.sample.pages;

import com.sample.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DahboardPage {

    public DahboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement pageSubtitle;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement arrowIcon;


    @FindBy(xpath = "//a[@class='no-hash']")
    public WebElement logOutBtn;




















}
