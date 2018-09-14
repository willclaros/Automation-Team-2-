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

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductsForm;
import com.jalasoft.sfdc.ui.pages.products.ProductsDetailPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
    private Product product;
    private Product productEdit;

    @And("^I go to Products page$")
    public void iGoToProductsPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        productsListPage = allAppsPage.goToProductsListPage();
    }

    @And("^I click New button Products$")
    public void iClickNewButtonProducts() {
        productsForm = productsListPage.clickNewBtn();
    }

    @And("^I create a new Product$")
    public void iCreateANewProduct(final List<Product> productList) {
        this.product = productList.get(0);
        product.setProductName(productList.get(0).getProductName());
        productsDetailPage = productsForm.createProduct(product);
    }

    @When("^I click Edit button$")
    public void iClickEditButton() {
        productsForm = productsDetailPage.clickEditBtn();
    }

    @And("^I edit information of a Product$")
    public void iEditInformationOfAProduct(final List<Product> productListEdit)  {
        this.product = productListEdit.get(0);
        product.setProductName(productListEdit.get(0).getProductName());
        productsDetailPage = productsForm.editProduct(product);
    }

    @Then("^The product information created should be displayed in the Product Detail Page$")
    public void theProductInformationCreatedShouldBeDisplayedInTheProductsListPage() {
        assertEquals(product.getProductName(), productsDetailPage.getProductNameTxt());
        assertEquals(product.getProductCode(), productsDetailPage.getProductCodeTxt());
        assertEquals(product.getProductDescription(), productsDetailPage.getProductDescriptionTxt());
    }

    @When("^I click Delete button$")
    public void iClickDeleteButton() {
        productsListPage = productsDetailPage.clickDeleteBtn();
    }

    @Then("^The product information delete shouldn't be displayed in the Product Detail Page$")
    public void theProductInformationDeleteShouldnTBeDisplayedInTheProductDetailPage()  {
       assertFalse(productsDetailPage.verifyDeletedProduct(product), "The product wasn't removed correctly");
    }
}
