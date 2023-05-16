package com.sample.step_definitions;

import com.sample.pages.DahboardPage;
import com.sample.pages.LoginPage;
import com.sample.utilities.BrowserUtils;
import com.sample.utilities.ConfigurationReader;
import com.sample.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogOut_Step_Defs {
   LoginPage lgn = new LoginPage();
   DahboardPage dashboard = new DahboardPage();

    @Given("{string} is on the the login page by entering {string} and {string}")
    public void is_on_the_the_login_page_by_entering_and(String userType, String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("navfort.url"));
        lgn.login(username,password);
        BrowserUtils.waitForClickablility(dashboard.arrowIcon,20);

    }
    @When("User go to profile menu and click the down arrow icon")
    public void user_go_to_profile_menu_and_click_the_down_arrow_icon() {
        BrowserUtils.waitForClickablility(dashboard.arrowIcon,20);
        dashboard.arrowIcon.click();


    }
    @When("User sees Logout button and click it")
    public void user_sees_logout_button_and_click_it() {
        dashboard.logOutBtn.click();
    }
    @Then("User should see login page")
    public void user_should_see_login_page() {
        String expectedHeader= ConfigurationReader.getProperty("login.header");
        BrowserUtils.waitForPresenceOfElement(By.xpath("//h2[.='Login']"),10);
        String actualHeader= lgn.loginHeader.getAttribute("textContent").trim();
        Assert.assertEquals("Login header verification Failed!!!",expectedHeader,actualHeader);
    }

















}
