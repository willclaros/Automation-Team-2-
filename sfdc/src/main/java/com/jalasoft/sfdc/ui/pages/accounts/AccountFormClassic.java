package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * AccountFormClassic class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountFormClassic extends AccountForm {

    private static final String NAME_ACCOUNT = "//*[@name='acc2']";
    private static final String BUTTON_SAVE = "//*[@name='save']";

    @FindBy(xpath = NAME_ACCOUNT )
    private WebElement nameAccountTxtBox ;

    @FindBy(xpath = BUTTON_SAVE)
    private WebElement saveBtn;

    @Override
    public void setFormAccount(String name) {
        driverTools.setInputField(nameAccountTxtBox, name);
    }

    /**
     * Method to access the account details page
     *
     * @return
     */
    @Override
    public AccountDetailsPage clickSaveBtn() {

        driverTools.clickElement(saveBtn);
        return new AccountDetailsPageClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        driverTools.clickElement(saveBtn);
    }
}
