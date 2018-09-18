package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.accounts.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountForm;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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

    @And("^I fill the following information in accounts$")
    public void iFillTheFollowingInformation(List<Account> accountList) {
        this.account = accountList.get(0);
        accountDetailsPage = accountForm.fillAccountForm(account);
    }


    @Then("^the created account should be displayed in account details page$")
    public void theCreatedAccountShouldBeDisplayedInDetailsAccountPage() {
        //assertEquals(account.getAccountName(),accountDetailsPage.getNameAccount());
        accountDetailsPage.verifyDataAccount(account);
    }

    @When("^I create a account with the following information$")
    public void iCreateAAccountWithTheFollowingInformation(List<Account> accountList) {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        accountsListPage = allAppsPage.goToaccount();
        accountForm = accountsListPage.createNewAccount();
        this.account = accountList.get(0);
        accountDetailsPage = accountForm.fillAccountForm(account);
    }

    @And("^I change the account information$")
    public void iChangeTheAccountInformation(List<Account> accountList1) {
        this.account = accountList1.get(0);
        accountDetailsPage = accountForm.editAccountData(account);
    }

    @Then("^the account should be edited by the new data$")
    public void theAccountShouldBeEditedByTheNewData() {
        accountDetailsPage.VerifyEditAccount(account);
    }

    @When("^I create an account with information$")
    public void iCreateAnAccountWithInformation(List<Account> accountList) {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        accountsListPage = allAppsPage.goToaccount();
        accountForm = accountsListPage.createNewAccount();
        this.account = accountList.get(0);
        accountDetailsPage = accountForm.fillAccountForm(account);
    }

    @And("^I delete this Account create$")
    public void iDeleteThisAccountCreate() {
        accountsListPage = accountDetailsPage.deleteAccount(account);
    }

    @Then("^I should see the Account is delete$")
    public void iShouldSeeTheAccountIsDelete() {
        assertFalse(accountsListPage.verifyDeleteAccount(account));
    }
}