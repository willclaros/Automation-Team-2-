package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsListPageLight extends AccountsListPage {

    @FindBy(xpath = "//a[@title='New']")
    private WebElement newAccount;

    public NewPageAccountLight createNewAccount() {
        driverTools.clickElement(newAccount);
        return new NewPageAccountLight();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
