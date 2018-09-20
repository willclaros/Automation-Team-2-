package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * AccountForm class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public abstract class AccountForm extends BasePage {
    public abstract AccountDetailsPage fillAccountForm(Account account);
    public abstract AccountDetailsPage editAccountData(Account account);
}
