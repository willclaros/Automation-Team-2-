package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountsListPageClassic class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountsListPageClassic extends AccountsListPage {

    private static final String BUTTON_NEW = "//*[@title='New']";
    private static final String BUTTON_EXIT = "//*[@class='dialogClose']";

    @FindBy(xpath = BUTTON_NEW )
    private WebElement newBtn;

    @FindBy(xpath = BUTTON_EXIT )
    private WebElement exitBtn;

    /**
     * Method to click on the buttons
     *
     * @return AccountFormClassic.
     */
    @Override
    public AccountForm createNewAccount() {
        if(exitBtn.isDisplayed()) {
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickElement(newBtn);
        return new AccountFormClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }
}
