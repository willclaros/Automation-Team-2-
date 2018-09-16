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

import com.jalasoft.sfdc.api.APIProduct;
import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductsForm;
import com.jalasoft.sfdc.ui.pages.products.ProductsDetailPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.xml.ws.Response;
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
    private Response response;

    private Product productAPI;
    private APIProduct apiProduct;

    @And("^I go to Products page$")
    public void iGoToProductsPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        productsListPage = allAppsPage.goToProductsListPage();
    }

    @And("^I click New Product button$")
    public void iClickNewButtonProducts() {
        productsForm = productsListPage.clickNewBtn();
    }

    @And("^I create a Product with the following information$")
    public void iCreateANewProduct(final List<Product> productList) {
        this.product = productList.get(0);
        apiProduct = new APIProduct(product);
        product.updateName();
        productsDetailPage = productsForm.createProduct(product);
    }

    @When("^I click Edit Product button$")
    public void iClickEditButton() {
        productsForm = productsDetailPage.clickEditBtn();
    }

    @And("^I edit the Product information$")
    public void iEditInformationOfAProduct(final List<Product> productListEdit)  {
        this.product = productListEdit.get(0);
        apiProduct = new APIProduct(product);
        productsDetailPage = productsForm.editProduct(product);
    }

    //(?:am logged in|login)
    @Then("^the (?:created|edited) product should be displayed in the Product Detail Page$")
    public void theProductInformationCreatedShouldBeDisplayedInTheProductsListPage() {
        assertEquals(product.getProductName(), productsDetailPage.getProductNameTxt());
        assertEquals(product.getProductCode(), productsDetailPage.getProductCodeTxt());
        assertEquals(product.getProductDescription(), productsDetailPage.getProductDescriptionTxt());
        //assertEquals(product.getStatusActive(), String.valueOf(productsDetailPage.getStatusChkBox()));
    }

    @When("^I click Delete Product button$")
    public void iClickDeleteButton() {
        productsListPage = productsDetailPage.clickDeleteBtn();
    }

    @Then("^The product deleted shouldn't be displayed in the Product Detail Page$")
    public void theProductInformationDeleteShouldnTBeDisplayedInTheProductDetailPage()  {
       assertFalse(productsDetailPage.verifyDeletedProduct(product), "The product wasn't removed correctly");
    }

    @Then("^the Product should be (?:created|updated)$")
    public void theProductShouldBeVerifiedByAPI() {
        productAPI = apiProduct.getProductsValuesByAPI();
        System.out.println("Expected-----------.--"+product.getProductName());
        System.out.println("esperado-------------"+productAPI.getProductName());
        assertEquals(product.getProductName(), productAPI.getProductName());
        assertEquals(product.getProductCode(), productAPI.getProductCode());
        assertEquals(product.getProductDescription(), productAPI.getProductDescription());
    }

    @Then("^the Product should be deleted$")
    public void theProductShouldDeletedByAPI() {
        apiProduct.deleteProductByAPI();
        //assertTrue(response.toString().isEmpty());
    }

    @After(value = "@DeleteProduct", order = 999)
    public void afterAccountScenario() {
        apiProduct.deleteProductByAPI();
    }

    @Given("^I have created a product with the following information$")
    public void iHaveCreatedAProductWithTheFollowingInformation(final List<Product> productList) {
        this.product = productList.get(0);
        apiProduct = new APIProduct(product);
        apiProduct.createProductByAPI();
    }

    @And("^I go by URL to the Product Details page$")
    public void iSelectTheProductByURL() throws Throwable {
       productsDetailPage = productsListPage.goToTheDetailsPage(product);
    }
}
