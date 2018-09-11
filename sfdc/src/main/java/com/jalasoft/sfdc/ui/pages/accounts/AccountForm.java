package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.ui.BasePage;

/**
 * AccountForm class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public abstract class AccountForm extends BasePage {
    public abstract void setFormAccount(String name);
    public abstract AccountDetailsPage clickSaveBtn();
}
