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
    public abstract void VerifyEditAccount(Account account);
}
