package com.jalasoft.sfdc.ui.pages.allappspage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;

public abstract class AllAppsPage extends BasePage {

    public abstract AccountsListPage goToaccount();

    public abstract ProductsListPage goToProductsListPage();


    public abstract ContactListPage goToContact();
}
