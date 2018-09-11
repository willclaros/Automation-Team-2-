package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsListPageClassic extends AccountsListPage {

    @FindBy(xpath = "//*[@title='New']")
    private WebElement newBtn;

    @FindBy(xpath = "//*[@class='dialogClose']")
    private WebElement exitBtn;

    public AccountForm createNewAccount() {
        driverTools.clickElement(exitBtn);
        driverTools.clickElement(newBtn);
        return new AccountFormClassic();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }
}
