package com.jalasoft.sfdc.steps;

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

public class ExamSteps {
    private AllAppsPage allAppsPage;
    private AccountsListPage accountsListPage;
    private HomePage homePage;
    private AccountForm accountForm;
    private AccountDetailsPage accountDetailsPage;

    private Account account;


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
    public void iChangeTheAccountInformation(List<Account> accountList) {
        this.account = accountList.get(0);
        accountDetailsPage = accountForm.editAccountData(account);
    }

    @Then("^the account should be edited by the new data$")
    public void theAccountShouldBeEditedByTheNewData() {
        accountDetailsPage.VerifyEditAccount(account);
    }
}
