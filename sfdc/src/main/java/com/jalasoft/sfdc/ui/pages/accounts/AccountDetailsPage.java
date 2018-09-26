package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * AccountDetailsPage class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public abstract class AccountDetailsPage extends BasePage {

    /**
     * Take the webElement chain.
     *
     * @return tex of WebElement.
     */
    public abstract void verifyDataAccount(Account account);
    public abstract String getAccountName();
    public abstract String getAccountNumber();
    public abstract String getAccountPhone();
    public abstract String getAccountFax();
    public abstract String getAccountTicker();
    public abstract void goToDetailsTab(Account account);
    public abstract boolean isAccountNameDisplayed(Account account);
    public abstract boolean isAccountNumberDisplayed(Account account);
    public abstract boolean isAccountFaxDisplayed(Account account);
    public abstract boolean isAccountTickerDisplayed(Account account);
    public abstract boolean isAccountPhoneDisplayed(Account account);
    public abstract AccountsListPage deleteAccount(Account account);
    public abstract AccountForm getToTheDetailsAccountPage();
}