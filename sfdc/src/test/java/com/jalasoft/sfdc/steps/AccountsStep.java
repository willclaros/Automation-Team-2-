package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.accounts.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountForm;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AccountsStep {
    private AllAppsPage allAppsPage;
    private AccountsListPage accountsListPage;
    private HomePage homePage;
    private AccountForm accountForm;
    private AccountDetailsPage accountDetailsPage;

    private Account account;


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

    @And("^I fill the following information$")
    public void iFillTheFollowingInformation(List<Account> accountList) {
        this.account = accountList.get(0);
        accountDetailsPage = accountForm.fillAccountForm(account);
    }


    @Then("^the created account should be displayed in account details page$")
    public void theCreatedAccountShouldBeDisplayedInDetailsAccountPage() {
        assertEquals(account.getAccountName(),accountDetailsPage.getNameAccount());
    }
}
