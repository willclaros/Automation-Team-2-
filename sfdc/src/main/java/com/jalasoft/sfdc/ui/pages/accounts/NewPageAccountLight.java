package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPageAccountLight extends NewPage {

    //WebDriverTools webDriverTools = new WebDriverTools();
    @FindBy(xpath = "//*[@id='231:3032;a']")
    private WebElement nameAccount;

    @FindBy(xpath = "//*[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
    private WebElement buttonSave;
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void setFormular(String name) {
        driverTools.setInputField(nameAccount, name);
    }

    private AccoutDetailsPage clickSaveBtn(){
        //return new AccoutDetailsPageLight();
        return null;
    }

    public AccoutDetailsPage createAccount() {
        //setFormular();
        return clickSaveBtn();
    }
}
