package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.accounts.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountForm;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class AccountsStep {
    private AllAppsPage allAppsPage;
    private AccountsListPage accountsListPage;
    private HomePage homePage;
    private AccountForm accountForm;
    private AccountDetailsPage accountDetailsPage;


    @When("^I go to Account page$")
    public void iGoToAccountPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        accountsListPage = allAppsPage.goToaccount();
    }

    @And("^I click new button$")
    public void iClickNewButton() {
        accountForm = accountsListPage.createNewAccount();
    }

    @And("^I fill the following information \"([^\"]*)\"$")
    public void iFillTheFollowingInformation(String name) {
         accountForm.setFormAccount(name);
    }


    @And("^I click Save button$")
    public void iClickSaveButton() {
        accountDetailsPage = accountForm.clickSaveBtn();
    }

    @Then("^the created account \"([^\"]*)\" should be displayed in details account page$")
    public void theCreatedAccountShouldBeDisplayedInDetailsAccountPage(String nameAccount) {
        assertEquals(nameAccount,accountDetailsPage.getNameAccount());
    }
}
