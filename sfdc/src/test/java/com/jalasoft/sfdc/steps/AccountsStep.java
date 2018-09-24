package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIAccount;
import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.accounts.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountForm;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AccountsStep {
    private AllAppsPage allAppsPage;
    private AccountsListPage accountsListPage;
    private HomePage homePage;
    private AccountForm accountForm;
    private AccountDetailsPage accountDetailsPage;
    private Account account;
    private Account accountApi;
    private APIAccount apiAccount;
    protected io.restassured.response.Response response;

    //****************************************************************
    //Account Step Definitions
    //****************************************************************

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
        account.setAccountName(accountList.get(0).getAccountName());
        accountDetailsPage = accountForm.fillAccountForm(account);
    }


    @Then("^the created account should be displayed in account details page$")
    public void theCreatedAccountShouldBeDisplayedInDetailsAccountPage() {
        accountDetailsPage.verifyDataAccount(account);
        assertEquals(accountDetailsPage.getAccountName(),account.getAccountName());
        assertEquals(accountDetailsPage.getAccountNumber(),account.getAccountNumber());
        assertEquals(accountDetailsPage.getAccountFax(),account.getFax());
        assertEquals(accountDetailsPage.getAccountPhone(),account.getPhone());
        assertEquals(accountDetailsPage.getAccountTicker(),account.getTicker());
    }

    //****************************************************************
    //Steps to edit an account
    //****************************************************************

    @When("^I create a account with the following information$")
    public void iCreateAAccountWithTheFollowingInformation(List<Account> accountList) {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        accountsListPage = allAppsPage.goToaccount();
        accountForm = accountsListPage.createNewAccount();
        this.account = accountList.get(0);
        account.setAccountName(accountList.get(0).getAccountName());
        accountDetailsPage = accountForm.fillAccountForm(account);
    }

    @And("^I change the account information$")
    public void iChangeTheAccountInformation(List<Account> accountList1) {
        this.account = accountList1.get(0);
        account.setAccountName(accountList1.get(0).getAccountName());
        accountDetailsPage = accountForm.editAccountData(account);
    }

    @Then("^the account should be edited by the new data$")
    public void theAccountShouldBeEditedByTheNewData() {
        accountDetailsPage.goToDetailsTab(account);
        assertTrue(accountDetailsPage.isAccountNameDisplayed(account));
        assertTrue(accountDetailsPage.isAccountPhoneDisplayed(account));
        assertTrue(accountDetailsPage.isAccountFaxDisplayed(account));
        assertTrue(accountDetailsPage.isAccountNumberDisplayed(account));
        assertTrue(accountDetailsPage.isAccountTickerDisplayed(account));
    }

    //****************************************************************
    //Steps to delete an account
    //****************************************************************

    @When("^I create an account with information$")
    public void iCreateAnAccountWithInformation(List<Account> accountList) {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        accountsListPage = allAppsPage.goToaccount();
        accountForm = accountsListPage.createNewAccount();
        this.account = accountList.get(0);
        account.setAccountName(accountList.get(0).getAccountName());
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

    @And("^I fill the following information in accounts by API$")
    public void iFillTheFollowingInformationInAccountsByAPI(List<Account> accountList) {
        this.account = accountList.get(0);
        apiAccount = new APIAccount(account);
        apiAccount.createAccountByAPI();
    }

    @Then("^the account should be created$")
    public void theAccountShouldBeCreated() {
        accountApi = apiAccount.getAccountValuesByAPI();
        assertEquals(accountApi.getAccountName(),account.getAccountName());
        assertEquals(accountApi.getAccountNumber(),account.getAccountNumber());
        assertEquals(accountApi.getFax(),account.getFax());
        assertEquals(accountApi.getPhone(),account.getPhone());
        assertEquals(accountApi.getTicker(),account.getTicker());
    }

    @When("^I create an account with information by Api$")
    public void iCreateAnAccountWithInformationByApi(List<Account> account) {
        iFillTheFollowingInformationInAccountsByAPI(account);
    }

    @And("^I delete this Account$")
    public void iDeleteThisAccount() {
        response = apiAccount.deleteAccountByAPI();
    }

    @Then("^The account must be deleted$")
    public void theAccountMustBeDeleted() {
        assertTrue(response.asString().isEmpty());
    }
}