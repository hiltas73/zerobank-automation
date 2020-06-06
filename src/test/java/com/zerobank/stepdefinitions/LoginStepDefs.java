package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enter {string} {string}")
    public void the_user_enter(String userName, String password) {
        if (userName.equals(ConfigurationReader.get("username")) && password.equals(ConfigurationReader.get("password"))) {
            new LoginPage().login(userName, password);
        }else{
            System.out.println("Login and/or password are wrong.");
            new LoginPage().login(userName, password);
        }
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        String expectedUrl = "http://zero.webappsecurity.com/bank/account-summary.html";
        Assert.assertTrue("verify successfully login",Driver.get().getCurrentUrl().contentEquals(expectedUrl));
    }

}
