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

public class LoginPage_Step_Defs {
        LoginPage lgn = new LoginPage();
        DahboardPage dashboard= new DahboardPage();

        @Given("The user is on the login page")
        public void the_user_is_on_the_login_page() {
                Driver.getDriver().get(ConfigurationReader.getProperty("navfort.url"));
        }
        @When("Log in as a {string}")
        public void log_in_as_a(String usertype) {
                System.out.println(usertype+" is on login page");
        }
        @When("The user enter {string} username field")
        public void the_user_enter_username_field(String username) {
            lgn.inputUsername.sendKeys(username);
        }
        @When("The user enter {string} password field")
        public void the_user_enter_password_field(String password) {
             lgn.inputPassword.sendKeys(password);
        }
        @When("The user click LOG IN button")
        public void the_user_click_log_ın_button() {
            lgn.loginBtn.click();
        }
        @Then("The user is on the {string} page")
        public void the_user_is_on_the_page(String page) {
              String expected = page;
              BrowserUtils.waitForPresenceOfElement(By.xpath("//h1[@class='oro-subtitle']"),25);
              String actual = dashboard.pageSubtitle.getAttribute("textContent").trim();
              Assert.assertEquals("Page Header verification Failed!!!",expected,actual);



        }









 /*
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("navfort.url"));
    }
    @When("The user enter {string} username field")
    public void the_user_enter_username_field(String username) {
        lgn.inputUsername.sendKeys(ConfigurationReader.getProperty("driver.username"));
        lgn.inputUsername.sendKeys(ConfigurationReader.getProperty("salesmanager.username"));
        lgn.inputUsername.sendKeys(ConfigurationReader.getProperty("storemanager.username"));

    }
    @When("The user enter {string} password field")
    public void the_user_enter_password_field(String password) {
        lgn.inputPassword.sendKeys(ConfigurationReader.getProperty("driver.password"));
        lgn.inputPassword.sendKeys("salesmanager.password");
        lgn.inputPassword.sendKeys("storemanager.password");

    }
    @When("The user click {string} button")
    public void the_user_click_button(String string) {
        lgn.loginBtn.click();

    }
    @Then("The user should see {string} on the page")
    public void the_user_should_see_on_the_page(String string) {
        BrowserUtils.waitForVisibility(dashboard.QuickLaunchpad,25);
        String expectedDriver="Quick Launchpad";
        String actualDriver=dashboard.QuickLaunchpad.getAttribute("textContent").trim();
        String expectedSalesmanager="Dashboard";
        BrowserUtils.waitForVisibility(dashboard.dashboard,25);
        String actualSalesmanager=dashboard.dashboard.getAttribute("textContent").trim();
        String expectedStoremanager="Dashboard";
        BrowserUtils.waitForVisibility(dashboard.dashboard,25);
        String actualStoremanager=dashboard.dashboard.getAttribute("textContent").trim();

        Assert.assertEquals("Quick Launchpad failed!!!",expectedDriver,actualDriver);
        Assert.assertEquals("Dashboard verification failed!!!",expectedSalesmanager,actualSalesmanager);
        Assert.assertEquals("Dashboard verification failed!!!",expectedStoremanager,actualStoremanager);


    }

  */




}
