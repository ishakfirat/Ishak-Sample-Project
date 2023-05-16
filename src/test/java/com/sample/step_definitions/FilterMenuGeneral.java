package com.NavFort.step_definitions;

import com.NavFort.pages.FilterMenuGeneralPage;
import com.NavFort.pages.LoginPage;
import com.NavFort.utilities.BrowserUtils;
import com.NavFort.utilities.ConfigurationReader;
import com.NavFort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FilterMenuGeneral {
    LoginPage lgnP = new LoginPage();
    FilterMenuGeneralPage fMGeneral= new FilterMenuGeneralPage();

    @Given("The {string} is already on the Fleet Management page")
    public void the_is_already_on_the_fleet_management_page(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        if (userType.equalsIgnoreCase("Driver")){
            lgnP.usernameField.sendKeys(ConfigurationReader.getProperty("driver.username"));
            lgnP.passwordField.sendKeys(ConfigurationReader.getProperty("all.pw"));
            lgnP.loginBtn.click();
            BrowserUtils.waitForPresenceOfElement(By.className("oro-subtitle"),25);
        } else if (userType.equalsIgnoreCase("Sales Manager")) {
            lgnP.usernameField.sendKeys(ConfigurationReader.getProperty("salesmanager.username"));
            lgnP.passwordField.sendKeys(ConfigurationReader.getProperty("all.pw"));
            lgnP.loginBtn.click();
            BrowserUtils.waitForPresenceOfElement(By.className("oro-subtitle"),25);
        }  else if (userType.equalsIgnoreCase("Store Manager")) {
        lgnP.usernameField.sendKeys(ConfigurationReader.getProperty("storemanager.username"));
        lgnP.passwordField.sendKeys(ConfigurationReader.getProperty("all.pw"));
        lgnP.loginBtn.click();
            BrowserUtils.waitForPresenceOfElement(By.className("oro-subtitle"),25);
    }


    }
    @When("The {string} is click the fleet menu and than click vehicles button")
    public void the_user_is_click_the_fleet_menu_and_than_click_vehicles_button(String userType) {
        if (userType.equalsIgnoreCase("Driver")){
            BrowserUtils.waitFor(3);
            fMGeneral.driverFleetBtn.click();
            fMGeneral.vehiclesBtn.click();

           // BrowserUtils.waitForClickablility(By.xpath("//a[@title='Filters']"),10);
        } else if (userType.equalsIgnoreCase("Sales Manager")) {
            BrowserUtils.waitFor(3);
            fMGeneral.salesStoreFleetBtn.click();
            fMGeneral.vehiclesBtn.click();

          //  BrowserUtils.waitForClickablility(By.xpath("//a[@title='Filters']"),10);

        }else if (userType.equalsIgnoreCase("Store Manager")) {
            BrowserUtils.waitFor(3);
            fMGeneral.salesStoreFleetBtn.click();
            fMGeneral.vehiclesBtn.click();
           // BrowserUtils.waitForClickablility(By.xpath("//a[@title='Filters']"),10);

        }

    }
    @When("The user click the filter icon")
    public void the_user_click_the_filter_icon() {
        BrowserUtils.waitFor(3);
        fMGeneral.filterIcon.click();

    }
    @Then("The user should see {string} button top left corner under the Cars header")
    public void the_user_should_see_button_top_left_corner_under_the_cars_header(String manageFilters) {
        BrowserUtils.waitForClickablility(By.xpath("//button[@type='button']/a"),10);
        String expected = "Manage filters";
        String actual= fMGeneral.manageFiltersBtn.getAttribute("textContent").trim();
        System.out.println("actual = " + actual);
        assertEquals("Manage filters Failed!!!",expected,actual);

    }


    @And("The user click {string} button")
    public void theUserClickButton(String manageFilters) {
        fMGeneral.manageFiltersBtn.click();

    }

    @Then("The user should see manage filters menu's contains filters")
    public void theUserShouldSeeManageFiltersMenuSContainsFilters() {


        List<String> expectedFilters= Arrays.asList("License Plate","Tags","Driver","Location","Chassis Number","Model Year","Last Odometer","Immatriculation Date","First Contract Date","Catalog Value (VAT Incl.)","Seats Number","Doors Number","Color","Transmission","Fuel Type","CO2 Emissions","Horsepower","Horsepower Taxation","Power (KW)");

        for (int i = 0; i < expectedFilters.size(); i++) {
            String expectedValue=expectedFilters.get(i);
            WebElement filter= fMGeneral.filters.get(i);
            String actualValue=filter.getText().trim();
            assertEquals(expectedValue,actualValue);

        }

    }





    @Then("The user types {string} on the filter input box and displayed on the screen")
    public void theUserTypesOnTheFilterInputBoxAndDisplayedOnTheScreen(String filtersName) {
        fMGeneral.filterSearchBox.sendKeys(filtersName);
        BrowserUtils.waitFor(2);
        fMGeneral.findFilter(filtersName);
        assertTrue(fMGeneral.findFilter(filtersName).isDisplayed());

    }


    @And("The user click on {string} ,{string} , {string}")
    public void theUserClickOn(String filter1, String filter2, String filter3) {
        fMGeneral.findFilter(filter1).click();
        fMGeneral.findFilter(filter2).click();
        fMGeneral.findFilter(filter3).click();
    }

    @Then("Verify that {string}, {string} and {string} options are selected")
    public void verifyThatAndOptionsAreSelected(String filter1, String filter2, String filter3) {
        assertTrue(fMGeneral.findFilter(filter1).isSelected());
        assertTrue(fMGeneral.findFilter(filter2).isSelected());
        assertTrue(fMGeneral.findFilter(filter3).isSelected());
    }
}
