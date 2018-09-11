package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.accounts.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountForm;
import com.jalasoft.sfdc.ui.pages.all_apps_page.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class AccountsStep {
    private AllAppsPage appLauncher;
    private AccountsListPage accountsPage;
    private HomePage homePage;
    private AccountForm newAccount;
    private AccountDetailsPage accountDetailsPage;


    @When("^I go to app list$")
    public void iGoToAppList() throws Throwable {
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.goToAllPages();

    }
    
    @When("^I go to Account page$")
    public void iGoToAccountPage() throws Throwable {
        accountsPage = appLauncher.goToaccount();
    }

    @And("^I click new button$")
    public void iClickNewButton() throws Throwable {
        newAccount = accountsPage.createNewAccount();
    }

    @And("^I fill the following information \"([^\"]*)\"$")
    public void iFillTheFollowingInformation(String name) throws Throwable {
         newAccount.setFormular(name);
    }

    @And("^click in save button$")
    public void clickInSaveButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Contact must be kept$")
    public void contactMustBeKept() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^The contact should be shown in the list of recent data$")
    public void theContactShouldBeShownInTheListOfRecentData() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @And("^I click Save button$")
    public void iClickSaveButton() {
        accountDetailsPage = newAccount.goToDetailsPage();
    }

    @Then("^the created account \"([^\"]*)\" should be displayed in details account page$")
    public void theCreatedAccountShouldBeDisplayedInDetailsAccountPage(String nameAccount) throws Throwable {
        assertEquals(nameAccount,accountDetailsPage.verifyElement());
    }
}
