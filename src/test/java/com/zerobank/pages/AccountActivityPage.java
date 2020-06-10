package com.zerobank.pages;

import com.google.common.collect.Ordering;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {

    /*public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }*/

    @FindBy(id = "aa_accountId")
    public WebElement Account;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement DateFrom;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement DateTo;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement FindBtn;

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement descriptionBtn;

    @FindBy(xpath = "(//div/table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[2]")
    public List<WebElement> descriptionTable;

    @FindBy(xpath = "(//tbody)[2]/tr/td[3]")
    public List<WebElement> depositTable;

    @FindBy(xpath = "(//tbody)[2]/tr/td[4]")
    public List<WebElement> withdrawalTable;

    @FindBy(xpath = "(//tbody)[2]/tr/td[1]")
    public List<WebElement> dateTable;

    public boolean inBetween(String dateFrom, String dateTo) {
        boolean b = true;

        int intDateFrom = Integer.parseInt(dateFrom.replace("-", ""));
        int intDateTo = Integer.parseInt(dateTo.replace("-", ""));
        System.out.println("intDateFrom = " + intDateFrom);
        System.out.println("intDateTo = " + intDateTo);
        System.out.println("--------------");

        for (WebElement eachDate : dateTable) {
            System.out.println("eachDate = " + eachDate.getText());
            String eachStr = eachDate.getText().replace("-", "");
            System.out.println("eachStr = " + eachStr);
            if (intDateTo < Integer.parseInt(eachStr) | Integer.parseInt(eachStr) < intDateFrom){
                b = false;
                break;
            }
        }
        System.out.println("b = " + b);
        return b;
    }

    public boolean isSorted() {
        List<String> list = BrowserUtils.getElementsText(dateTable);
        boolean sorted = Ordering.natural().reverse().isOrdered(list);
        System.out.println("list = " + list);
        return sorted;
    }

    public void enterDates(String fromDate, String toDate) throws InterruptedException {
        Thread.sleep(1000);
        new AccountActivityPage().DateFrom.clear();
        new AccountActivityPage().DateFrom.sendKeys(fromDate);
        Thread.sleep(1000);
        new AccountActivityPage().DateTo.clear();
        new AccountActivityPage().DateTo.sendKeys(toDate);
        Thread.sleep(1000);
    }


    public void navigateFindTransactions() {
        BasePage basePage = new BasePage();
        basePage.navigateToModule("Account Activity");
        basePage.navigateToModule("Find Transactions");
    }

    public boolean isSelected(String str) {
        AccountActivityPage activityPage = new AccountActivityPage();
        Select dropDown = new Select(activityPage.Account);
        String actualOption = dropDown.getFirstSelectedOption().getText();
        String expectedOption = str;
        //System.out.println("actualOption = " + actualOption);
        //System.out.println("expectedOption = " + expectedOption);
        //Assert.assertEquals("Verify first selected option is "+expectedOption+" ",expectedOption,actualOption);

        if (expectedOption.equals(actualOption)) {
            return true;
        } else {
            return false;
        }

    }

}

