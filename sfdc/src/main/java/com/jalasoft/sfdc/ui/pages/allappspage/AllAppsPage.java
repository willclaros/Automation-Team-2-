/*
 * @(#)AllAppsPage.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jalasoft.sfdc.ui.pages.allappspage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;

/**
 * Abstract class that contains WebElements that redirect us to features.
 */
public abstract class AllAppsPage extends BasePage {

    /**
     * Abstract method that redirects to Accounts List Page when pressing the WebElement.
     *
     * @return returns the Accounts List Page
     */
    public abstract AccountsListPage goToaccount();

    /**
     * Abstract method that redirects to Products List Page when pressing the WebElement.
     *
     * @return returns the Products List Page
     */
    public abstract ProductsListPage goToProductsListPage();

    /**
     * Abstract method that redirects to Price Books List Page when pressing the WebElement.
     *
     * @return returns the Price Books List Page
     */
    public abstract PriceBookListPage goToPriceBooksListPage();

    /**
     * Abstract method that redirects to Contacts List Page when pressing the WebElement.
     *
     * @return returns the Contacts List Page
     */
    public abstract ContactListPage goToContact();
}
