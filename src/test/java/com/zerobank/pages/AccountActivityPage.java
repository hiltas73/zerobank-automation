package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

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

}
