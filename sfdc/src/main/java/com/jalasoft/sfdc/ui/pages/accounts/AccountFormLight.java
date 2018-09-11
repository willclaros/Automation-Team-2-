package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountFormLight class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountFormLight extends AccountForm {

    private static final String NAME_ACCOUNT = "//*[@class='input uiInput uiInputText uiInput--default uiInput--input']";
    private static final String BUTTON_SAVE = ".slds-button[title|='Save']";


    @FindBy(xpath = NAME_ACCOUNT )
    private WebElement nameAccountTxtBox ;

    @FindBy(css = BUTTON_SAVE )
    private WebElement buttonSave;

    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(nameAccountTxtBox));
    }

    @Override
    public void setFormAccount(String name) {
        driverTools.setInputField(nameAccountTxtBox, name);
    }

    @Override
    public AccountDetailsPage clickSaveBtn() {
        driverTools.clickElement(buttonSave);
        return new AccountDetailsPageLight();
    }

}
