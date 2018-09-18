package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountsListPageLight class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountsListPageLight extends AccountsListPage {

    private static final String BUTTON_ACCOUNTS = "//a[@title='New']" ;

    @FindBy(xpath = BUTTON_ACCOUNTS )
    private WebElement accountsBtn;



    /**
     * Method to click on the account button to create a new one.
     *
     * @return the form to fill in with the account details.
     */
    public AccountForm createNewAccount() {

        driverTools.clickElement(accountsBtn);
        return new AccountFormLight();
    }

    @Override
    public boolean verifyDeleteAccount(Account account) {
        String nameAccountDelete = account.getAccountName();
        return driverTools.isElementDisplayed(By.xpath("//a[text()='"+nameAccountDelete+"']"));
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(accountsBtn));
    }
}
