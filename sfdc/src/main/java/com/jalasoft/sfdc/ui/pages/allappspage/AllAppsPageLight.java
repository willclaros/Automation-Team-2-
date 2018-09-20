/*
 * @(#)AllAppsPageLight.java
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

import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPageLight;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class that contains WebElements that redirect us to the skin light features.
 */
public class AllAppsPageLight extends AllAppsPage {

    @FindBy(css = ".slds-input[placeholder *='Find an app']")
    private WebElement searchTxtBox;

    @FindBy(xpath = "//mark[text()='Accounts']")
    private WebElement accountButton;


    @FindBy(css = ".app-launcher-link[title*='Product'] .label-ctr .slds-text-link")
    private WebElement productsBtn;

    @FindBy(css = ".app-launcher-link[title*='Price Books'] .label-ctr .slds-text-link")
    private WebElement priceBooksBtn;

    @FindBy(css = "a[title|='Contacts']")
    private WebElement contactsBtn;

    @FindBy(css = ".uiInputText .slds-input.input")
    private WebElement searchTxtBx;


    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(searchTxtBox));
    }

    /**
     * Method that redirects to Accounts List Page of skin light when pressing the WebElement.
     *
     * @return returns the Accounts List Page
     */
    @Override
    public AccountsListPage goToaccount() {
        driverTools.setInputField(searchTxtBx,"Accounts");
        wait.until(ExpectedConditions.visibilityOf(accountButton));
        driverTools.clickElement(accountButton);
        return new AccountsListPageLight();
    }

    /**
     * Method that redirects to Products List Page of skin light when pressing the WebElement.
     *
     * @return returns the Products List Page
     */
    @Override
    public ProductsListPage goToProductsListPage() {
        setSearchTxtBox(productsBtn);
        return new ProductsListPageLight();
    }

    /**
     * Method that redirects to Price Books List Page of skin light when pressing the WebElement.
     *
     * @return returns the Price Books List Page
     */
    @Override
    public PriceBookListPage goToPriceBooksListPage() {
        setSearchTxtBox(priceBooksBtn);
        return new PriceBookListPageLight();
    }

    /**
     * Method that redirects to Contacts List Page of skin light when pressing the WebElement.
     *
     * @return returns the Contacts List Page
     */
    @Override
    public ContactListPage goToContact() {
        setSearchTxtBox(contactsBtn);
        return new ContactListPageLight();
    }

    /**
     * Method that sets the searcher's text field, using its getText () method of the element that we want to find on the page.
     *
     * @param webElement element that we want to find on the page.
     */
    public void setSearchTxtBox(WebElement webElement) {
        driverTools.clickElement(searchTxtBox);
        driverTools.setInputField(searchTxtBox, webElement.getText());
        driverTools.clickElement(webElement);
    }
}
