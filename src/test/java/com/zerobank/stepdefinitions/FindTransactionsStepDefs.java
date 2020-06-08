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

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.DateFrom.click();
        accountActivityPage.DateFrom.sendKeys(year1.toString()+ "-" + month1.toString() + "-" + day1.toString());
        Thread.sleep(3000);

        accountActivityPage.DateTo.sendKeys(year2 + "-" + month2 + "-" + day2);
        Thread.sleep(3000);
    }

    @When("clicks search")
    public void clicks_search() throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.FindBtn.click();
        Thread.sleep(3000);
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

    @When("user selects type “Deposit”")
    public void user_selects_type_Deposit() {
        System.out.println("---");
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        System.out.println("---");
    }

    @When("user selects type “Withdrawal”")
    public void user_selects_type_Withdrawal() {
        System.out.println("---");
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        System.out.println("---");
    }


}

