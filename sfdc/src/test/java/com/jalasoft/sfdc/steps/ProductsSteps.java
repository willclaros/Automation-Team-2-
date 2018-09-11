package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.new_page_product.NewPageProducts;
import com.jalasoft.sfdc.ui.pages.products.product_detail_page.ProductsDetailPage;
import com.jalasoft.sfdc.ui.pages.products.product_list_page.ProductsListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class ProductsSteps {

    private AllAppsPage allAppsPage;
    private ProductsListPage productsListPage;
    private HomePage homePage;
    private NewPageProducts newProduct;
    private ProductsDetailPage productsDetailPage;


    @When("^I go to app list product$")
    public void iGoToAppListProduct() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
    }

    @And("^I go to Products page$")
    public void iGoToProductsPage() {
        productsListPage = allAppsPage.goToProducts();
    }

    @And("^I click New button Products$")
    public void iClickNewButtonProducts() {
        newProduct = productsListPage.createNewProduct();
    }

    @And("^Fill the following information \"([^\"]*)\"$")
    public void fillTheFollowingInformation(String name) {
        productsDetailPage = newProduct.setFormular(name);
    }

    @And("^I click the Save button$")
    public void iClickTheSaveButton() {
        productsDetailPage = newProduct.clickSaveBtn();
    }

    @Then("^I verify that product is created \"([^\"]*)\"$")
    public void iVerifyThatProductIsCreated(String product) {
        assertEquals(product, productsDetailPage.verifyCreateProduct());
    }
}
