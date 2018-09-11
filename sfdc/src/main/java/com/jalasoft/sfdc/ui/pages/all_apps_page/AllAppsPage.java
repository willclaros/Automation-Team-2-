package com.jalasoft.sfdc.ui.pages.all_apps_page;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.products.product_list_page.ProductsListPage;

public abstract class AllAppsPage extends BasePage {

    public abstract AccountsListPage goToaccount();

    public abstract ProductsListPage goToProducts();

    public abstract PriceBookListPage goToPriceBooks();

}
