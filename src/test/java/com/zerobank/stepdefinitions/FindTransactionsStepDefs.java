package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        new BasePage().navigateToModule("Account Activity");
        new BasePage().navigateToModule("Find Transactions");
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateFrom, String dateTo) throws InterruptedException {
        new AccountActivityPage().enterDates(dateFrom, dateTo);
    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().FindBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions between {string} to {string}")
    public void results_table_should_only_show_transactions_between_to(String dateFrom, String dateTo) {
        Assert.assertTrue("verify result table show only transactions between " + dateFrom
                + " to " + dateTo, new AccountActivityPage().inBetween(dateFrom,dateTo));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        //System.out.println("new AccountActivityPage().isSorted() = " + new AccountActivityPage().isSorted());
        Assert.assertTrue("verify results should be sorted by most recent date",new AccountActivityPage().isSorted());
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        //System.out.println("BrowserUtils.getElementsText(new AccountActivityPage().dateTable) = " + BrowserUtils.getElementsText(new AccountActivityPage().dateTable));
        //System.out.println("date = " + date);
        Assert.assertFalse("the results table should only not contain transactions dated "+date,BrowserUtils.getElementsText(new AccountActivityPage().dateTable).contains(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String searchItem) {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().descriptionBtn.clear();
        new AccountActivityPage().descriptionBtn.sendKeys(searchItem);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String searchItem) {
        for (WebElement each : new AccountActivityPage().descriptionTable) {
            System.out.println("each = " + each.getText());
            Assert.assertTrue("Verify description only show \"ONLINE\" transactions", each.getText().startsWith(searchItem));

        }
    }

    @Then("results table should show no results containing {string}")
    public void results_table_should_show_no_results_containing(String string) {
        System.out.println("AccountActivityPage().noResultTab = " + new AccountActivityPage().noResultTab.getText());
        Assert.assertTrue("verify no result is displayed",new AccountActivityPage().noResultTab.isDisplayed());
    }



    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    /*@Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));

        new AccountActivityPage().navigateFindTransactions();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        //accountActivityPage.DateFrom.click();
        accountActivityPage.DateFrom.sendKeys(fromDate);
        Thread.sleep(2000);

        accountActivityPage.DateTo.sendKeys(toDate);
        Thread.sleep(2000);
    }

    @Then("results table should only show transactions between {string} to {string}")
    public void results_table_should_only_show_transactions_between_to(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clicks search")
    public void clicks_search() throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.FindBtn.click();
        Thread.sleep(3000);
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

    *//*@Then("results table should not show descriptions containing “OFFICE”")
    public void results_table_should_not_show_descriptions_containing_OFFICE() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        for (WebElement each : accountActivityPage.descriptionTable) {
            Assert.assertFalse("Verify description NOT show \"OFFICE\" transactions", each.getText().startsWith("OFFICE"));
        }
    }*//*

    @When("the user enters description “online”")
    public void the_user_enters_description_online() throws InterruptedException {
        new AccountActivityPage().descriptionBtn.clear();
        Thread.sleep(2000);
        new AccountActivityPage().descriptionBtn.sendKeys("online" + Keys.ENTER);
        Thread.sleep(2000);
    }


    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        int num = 0;

        for (WebElement each : accountActivityPage.depositTable) {
            System.out.println("each = " + each.getText());
            Thread.sleep(3000);
            if (each.getText() != null){
                try {
                    num++;
                    System.out.println("each = " + Double.parseDouble(each.getText()));
                }catch (Exception e){
                    num+=0;
                }
            }

        }
        //System.out.println("num = " + num);

        Assert.assertTrue("Verify results table should show at least one result under Deposit",num>0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        int num = 0;

        for (WebElement each : accountActivityPage.withdrawalTable) {
            System.out.println("each = " + each.getText());
            Thread.sleep(3000);
            if (each.getText() != null){
                try {
                    num++;
                    System.out.println("each = " + Double.parseDouble(each.getText()));
                }catch (Exception e){
                    num+=0;
                }
            }

        }
        //System.out.println("num = " + num);

        Assert.assertTrue("Verify results table should show at least one result under Withdrawal",num>0);
    }
*/
}

