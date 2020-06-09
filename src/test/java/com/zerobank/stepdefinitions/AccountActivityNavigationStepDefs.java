package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @When("the user clicks on	{string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {
        new AccountSummaryPage().clickLink(accountType);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String pageName) {
        String expectedTitle = "Zero - Account Activity";
        Assert.assertEquals("verify " + pageName + " is displayed", Driver.get().getTitle(), expectedTitle);
    }

   @Then("Account	drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String accountName) {
        Assert.assertTrue("verify drop down should have "+accountName+" selected", new AccountActivityPage().isSelected(accountName));
    }

}
