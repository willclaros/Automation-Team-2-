package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsListPageLight extends AccountsListPage {

    @FindBy(xpath = "//a[@title='New']")
    private WebElement accountsBtn;

    public AccountForm createNewAccount() {
        driverTools.clickElement(accountsBtn);
        return new AccountFormLight();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
