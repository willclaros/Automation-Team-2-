/*
 * @(#)ProductsSteps.java
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
package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductsForm;
import com.jalasoft.sfdc.ui.pages.products.ProductsDetailPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

/**
 * Class that contains the steps to execute the Product scenarios.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsSteps {

    private AllAppsPage allAppsPage;
    private ProductsListPage productsListPage;
    private HomePage homePage;
    private ProductsForm productsForm;
    private ProductsDetailPage productsDetailPage;


    @When("^I go to app list product$")
    public void iGoToAppListProduct() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
    }

    @And("^I go to Products page$")
    public void iGoToProductsPage() {
        productsListPage = allAppsPage.goToProductsListPage();
    }

    @And("^I click New button Products$")
    public void iClickNewButtonProducts() {
        productsForm = productsListPage.clickNewBtn();
    }

    @And("^Fill the following information \"([^\"]*)\"$")
    public void fillTheFollowingInformation(String name) {
        productsForm.setFormProduct(name);
    }

    @And("^I click the Save button$")
    public void iClickTheSaveButton() {
        productsDetailPage = productsForm.clickSaveBtn();
    }

    @Then("^The product information created \"([^\"]*)\" should be displayed in the Products List Page$")
    public void theProductInformationCreatedShouldBeDisplayedInTheProductsListPage(String product) {
        assertEquals(product, productsDetailPage.getProductNameTxt(), "The product was correctly created and saved.");
    }
}
