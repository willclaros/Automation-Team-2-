package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIQuote;
import com.jalasoft.sfdc.entities.*;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPage;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityForm;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityListPage;
import com.jalasoft.sfdc.ui.pages.quotes.AddProductsFormQuotes;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesDetailPage;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class OpportunitySteps {
    private AllAppsPage allAppsPage;
    private HomePage homePage;
    private OpportunityForm opportunityForm;
    private OpportunityDetailPage opportunityDetailPage;
    private Opportunity opportunity;
    private OpportunityListPage opportunityListPage;
    private AddProductsFormQuotes addProductsFormQuotes;
    private QuotesForm quotesForm;
    private QuotesDetailPage quotesDetailPage;
    private Quote quote;
    private APIQuote apiQuote;
    private Container container;
    private QuoteLineItems quoteLineItems;
    private Quote quoteApi;

    public OpportunitySteps(Container container) {
        this.container = container;
    }

    @When("^I go to Opportunity page$")
    public void iGoToAppListOpportunity() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        opportunityListPage = allAppsPage.goToOpportunityListPage();
    }

    @And("^I click New button Opportunity$")
    public void iClickNewButtonOpportunity() {
        opportunityForm = opportunityListPage.clickNewBtn();
    }

    @And("^I create an Opportunity$")
    public void iCreateOpportunity(final List<Opportunity> opportunityList) {
        this.opportunity = opportunityList.get(0);
        opportunityDetailPage = opportunityForm.setFormOpportunity(opportunity);
    }

    @Then("^the created opportunity should be displayed in the Opportunity Detail Page$")
    public void theOpportunityInformationCreatedShouldBeDisplayedInTheOpportunityDetailPage() {
        opportunityDetailPage.goToDetails();
        assertEquals(opportunity.getNameOpportunity(), opportunityDetailPage.getNameTxt(), "The opportunity name wasn't correctly created and saved.");
    }

    @When("^I create a new Quote Name$")
    public void iCreateANewQuoteWithName(final List<Quote> quotesList) {
        this.quote = quotesList.get(0);
        apiQuote = new APIQuote(quote);
        container.setQuote(quote);
        quotesForm = opportunityDetailPage.goToNewQuotes();
        quotesDetailPage = quotesForm.createQuote(quote);
        addProductsFormQuotes = quotesDetailPage.goToAddProducts();
    }

    @And("^I add the following line item$")
    public void iAddTheFollowingLineItem(List<QuoteLineItems> quoteLineItemsList) {
        this.quoteLineItems = quoteLineItemsList.get(0);
        container.setQuoteLineItems(quoteLineItems);
        quotesDetailPage = addProductsFormQuotes.fillDataProducts(container.getProduct(), container.getQuoteLineItems());
    }

    @Then("^I verify that the sum of all the prices is correct in the Quote Detail Page$")
    public void iVerifyThatTheSumOfAllThePricesIsCorrectInTheQuoteDetailPage() {
        quoteApi = apiQuote.getQuotesValuesByAPI();
        assertEquals(Double.parseDouble(quotesDetailPage.verifyPriceTotal()), Double.parseDouble(quoteApi.getSubTotal()));
    }

    @And("^I verify that the sum of all the prices is correct by API$")
    public void iVerifyThatTheSumOfAllThePricesIsCorrectByAPI() {
        quoteApi = apiQuote.getQuotesValuesByAPI();
        double price = Double.parseDouble(container.getQuoteLineItems().getPrice());
        double quantity = Double.parseDouble(container.getQuoteLineItems().getQuantity());
        assertEquals(Double.parseDouble(quoteApi.getSubTotal()), (price * quantity));
    }
}
