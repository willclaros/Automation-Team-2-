package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountFormClassic extends AccountForm {

    @FindBy(xpath = "//*[@name='acc2']")
    private WebElement nameAccountTxtBox ;

    @FindBy(xpath = "//*[@name='save']")
    private WebElement saveBtn;

    @Override
    public void setFormular(String name) {
        driverTools.setInputField(nameAccountTxtBox, name);
    }

    @Override
    public AccountDetailsPage goToDetailsPage() {
        driverTools.clickElement(saveBtn);
        return new AccountDetailsPageClassic();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
