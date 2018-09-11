package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountFormLight extends AccountForm {

    //WebDriverTools webDriverTools = new WebDriverTools();
    @FindBy(xpath = "//*[@class='input uiInput uiInputText uiInput--default uiInput--input']")
    private WebElement nameAccount;

    @FindBy(css = ".slds-button[title|='Save']")
    private WebElement buttonSave;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void setFormular(String name) {
        driverTools.setInputField(nameAccount, name);
    }

    @Override
    public AccountDetailsPage goToDetailsPage() {
        driverTools.clickElement(buttonSave);
        return new AccountDetailsPageLight();
    }

    private AccountsListPage clickSaveBtn(){
        //return new AccoutDetailsPageLight();
        return null;
    }

    public AccountsListPage createAccount() {
        //setFormular();
        return clickSaveBtn();
    }
}
