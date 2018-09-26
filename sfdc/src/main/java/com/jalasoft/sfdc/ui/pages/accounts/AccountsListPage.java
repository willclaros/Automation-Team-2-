package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * AccountsListPage class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public abstract class AccountsListPage extends BasePage {
    public abstract AccountForm createNewAccount();
    public abstract boolean verifyDeleteAccount(Account account);
    public abstract AccountDetailsPage goToTheDetailsPage(Account account);
}
