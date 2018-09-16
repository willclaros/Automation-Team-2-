package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.entities.Opportunity;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPage;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityForm;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityListPage;
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
    private Account account;

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
//        account.setAccountName(account.getAccountName());
        opportunityDetailPage = opportunityForm.setFormOpportunity(opportunity);
    }

    @Then("^the created opportunity should be displayed in the Opportunity Detail Page$")
    public void theOpportunityInformationCreatedShouldBeDisplayedInTheOpportunityDetailPage() {
        opportunityDetailPage.goToDetails();
        assertEquals(opportunity.getNameOpportunity(), opportunityDetailPage.getNameTxt(), "The opportunity name wasn't correctly created and saved.");
        //assertEquals(opportunity.getDescription(), opportunityDetailPage.getPriceBookDescriptionTxt(), "The product description wasn't correctly created and saved.");
    }
}
