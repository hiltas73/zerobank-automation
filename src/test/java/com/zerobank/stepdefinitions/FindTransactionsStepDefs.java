package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class FindTransactionsStepDefs extends BasePage {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));

        BasePage basePage = new BasePage();
        basePage.navigateToModule("Account Activity");
        Thread.sleep(3000);
        basePage.navigateToModule("Find Transactions");
        Thread.sleep(3000);
    }

    @When("the user enters date range from “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void the_user_enters_date_range_from_to(Integer year1, Integer month1, Integer day1, Integer year2, Integer month2, Integer day2) throws InterruptedException {
        /*String year1Str = Integer.toString(year1);
        String month1Str = Integer.toString(month1);
        String day1Str = Integer.toString(day1);
        System.out.println("year1Str = " + year1Str);
        System.out.println("month1Str = " + month1Str);
        System.out.println("day1Str = " + day1Str);

        String year2Str = year2.toString();
        String month2Str = month2.toString();
        String day2Str = day2.toString();*/

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.DateFrom.sendKeys(Integer.valueOf(year1) + "-" + Integer.valueOf(month1) + "-" + Integer.valueOf(day1));
        Thread.sleep(3000);

        accountActivityPage.DateTo.sendKeys(Integer.valueOf(year2) + "-" + Integer.valueOf(month2) + "-" + Integer.valueOf(day2));
        Thread.sleep(3000);
    }

    @When("clicks search")
    public void clicks_search() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.FindBtn.click();
    }

    @Then("results table should only show transactions dates between “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void results_table_should_only_show_transactions_dates_between_to(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        System.out.println("...");
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        System.out.println("...");
    }

    @Then("the results table should only not contain transactions dated “{int}-{int}-{int}”")
    public void the_results_table_should_only_not_contain_transactions_dated(Integer int1, Integer int2, Integer int3) {
        System.out.println("...");
    }

    @When("the user enters description “ONLINE”")
    public void the_user_enters_description_ONLINE() {
        new AccountActivityPage().descriptionBtn.sendKeys("ONLINE" + Keys.ENTER);

    }

    @Then("results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_ONLINE() throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        for (WebElement each : accountActivityPage.descriptionTable) {
            Assert.assertTrue("Verify description only show \"ONLINE\" transactions", each.getText().startsWith("ONLINE"));
            Thread.sleep(2000);
        }
    }

    @When("the user enters description “OFFICE”")
    public void the_user_enters_description_OFFICE() throws InterruptedException {
        new AccountActivityPage().descriptionBtn.clear();
        Thread.sleep(2000);
        new AccountActivityPage().descriptionBtn.sendKeys("OFFICE" + Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("results table should only show descriptions containing “OFFICE”")
    public void results_table_should_only_show_descriptions_containing_OFFICE() throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        for (WebElement each : accountActivityPage.descriptionTable) {
            Assert.assertTrue("Verify description only show \"OFFICE\" transactions", each.getText().startsWith("OFFICE"));
            Thread.sleep(2000);
        }
    }

    /*@Then("results table should not show descriptions containing “OFFICE”")
    public void results_table_should_not_show_descriptions_containing_OFFICE() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        for (WebElement each : accountActivityPage.descriptionTable) {
            Assert.assertFalse("Verify description NOT show \"OFFICE\" transactions", each.getText().startsWith("OFFICE"));
        }
    }*/

}

