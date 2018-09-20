package com.jalasoft.sfdc.ui.pages.allappspage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;

public abstract class AllAppsPage extends BasePage {

    public abstract AccountsListPage goToaccount();

    public abstract ProductsListPage goToProductsListPage();

    /**
     * Abstract method that redirects to Price Books List Page when pressing the WebElement.
     *
     * @return returns the Price Books List Page
     */
    public abstract PriceBookListPage goToPriceBooksListPage();

    public abstract ContactListPage goToContact();
}
