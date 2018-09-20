/*
 * @(#)PriceBookSteps.java
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

import com.jalasoft.sfdc.entities.PriceBook;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBooksForm;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookDetailPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Class that contains the steps to execute the Price Books scenarios.
 *
 * @author William Claros Revollo
 * @since 9/16/2018
 */
public class PriceBookSteps {

    private AllAppsPage allAppsPage;
    private PriceBookListPage priceBookListPage;
    private HomePage homePage;
    private PriceBooksForm priceBooksForm;
    private PriceBookDetailPage priceBookDetailPage;
    private PriceBook priceBook;

    @When("^I go to Price Book page$")
    public void iGoToAppListPriceBooks() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        priceBookListPage = allAppsPage.goToPriceBooksListPage();
    }

    @And("^I click New button Price Book$")
    public void iClickNewButtonPriceBook() {
        priceBooksForm = priceBookListPage.clickNewBtn();
    }

    @And("^I fill the following information in form Price Book$")
    public void fillTheFollowingInformation(final List<PriceBook> priceBookList) {
        this.priceBook = priceBookList.get(0);
        priceBookDetailPage = priceBooksForm.setFormPriceBook(priceBook);
    }

    @Then("^The Price Book is information created should be displayed in the Price Book Detail Page$")
    public void thePriceBookInformationCreatedShouldBeDisplayedInThePriceBookDetailPage() {
        assertEquals(priceBook.getPriceBookName(), priceBookDetailPage.getPriceBookNameTxt(), "The product name wasn't correctly created and saved.");
    }
}
