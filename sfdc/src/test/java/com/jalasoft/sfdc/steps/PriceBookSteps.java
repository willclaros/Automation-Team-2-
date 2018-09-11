package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.pricebook.NewPagePriceBooksLight;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookDetailPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PriceBookSteps {

    private AllAppsPage allAppsPage;
    private PriceBookListPage priceBookListPage;
    private HomePage homePage;
    private NewPagePriceBooksLight newPriceBook;
    private PriceBookDetailPage priceBookDetailPage;

    @When("^I go to app list Price Books$")
    public void iGoToAppListPriceBooks() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
    }

    @And("^I go to Price Book page$")
    public void iGoToPriceBookPage() {
        homePage = PageFactory.getHomePage();
        priceBookListPage = allAppsPage.goToPriceBooks();
    }

    @And("^I click New button Price Book$")
    public void iClickNewButtonPriceBook() {
        newPriceBook = priceBookListPage.createNewPriceBooks();

    }

    @And("^Fill the following information \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void fillTheFollowingInformation(String nameBook, String description, String value) {
        priceBookDetailPage = newPriceBook.setForm(nameBook,description,value);
        priceBookDetailPage = newPriceBook.clickSaveBtn();
    }

   /* @And("^I click Save button$")
    public void iClickSaveButton() {
        priceBookDetailPage = newPriceBook.clickSaveBtn();
    }*/

    @Then("^I verify that Price Book is created \"([^\"]*)\"$")
    public void iVerifyThatPriceBookIsCreated(String arg0) {

    }


}
