package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class AccountForm extends BasePage {
    public abstract void setFormular(String name);
    public abstract AccountDetailsPage goToDetailsPage();
}
