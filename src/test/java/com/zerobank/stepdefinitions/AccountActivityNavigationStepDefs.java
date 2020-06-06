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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class AccountActivityNavigationStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @When("the user clicks on {string} link on the {string} page")
    public void the_user_clicks_on_link_on_the_page(String link, String page) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(Driver.get().findElement(By.linkText(link))).click().perform();
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String pageName) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());
        String actualPageTitle = Driver.get().getTitle();
        String expectedPageTitle = "Zero - " + pageName;
        Assert.assertEquals("Verify "+pageName+" is displayed successfully",actualPageTitle,expectedPageTitle);

    }

    @Then("Account drop down should have {string} selected")
    public void drop_down_should_have_selected(String expectedOption) {
        AccountActivityPage activityPage = new AccountActivityPage();
        Select dropDown = new Select(activityPage.Account);
        String actualOption = dropDown.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);
        System.out.println("expectedOption = " + expectedOption);
        Assert.assertEquals("Verify first selected option is "+expectedOption,expectedOption,actualOption);
    }
}
