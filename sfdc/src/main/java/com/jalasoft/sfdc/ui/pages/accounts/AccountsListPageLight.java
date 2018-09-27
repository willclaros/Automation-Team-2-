package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountsListPageLight class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountsListPageLight extends AccountsListPage {

    private static String VERIFY_TEXT_INIT = "//a[text()='";
    private static String VERIFY_TEXT_END = "']";
    private static String TEXT_URL_INIT = "https://na49.lightning.force.com/lightning/r/Account/";
    private static String TEXT_URL_END = "/view";


    @FindBy(xpath = "//a[@title='New']" )
    private WebElement accountsBtn;

    /**
     * Method to click on the account button to create a new one.
     *
     * @return the form to fill in with the account details.
     */
    public AccountForm createNewAccount() {

        driverTools.clickElement(accountsBtn);
        return new AccountFormLight();
    }

    /**
     * Method that verifies if the element is displayed in the page
     *
     * @param account entities
     *
     * @return true or false
     */
    @Override
    public boolean verifyDeleteAccount(Account account) {
        String nameAccountDelete = account.getAccountName();
        return driverTools.isElementDisplayed(By.xpath(VERIFY_TEXT_INIT+nameAccountDelete+VERIFY_TEXT_END));
    }

    /**
     * Method that get page details
     *
     * @param account entities
     *
     * @return AccountDetailsPageClassic
     */
    @Override
    public AccountDetailsPage goToTheDetailsPage(Account account) {
        driver.navigate().to(TEXT_URL_INIT+account.getId()+TEXT_URL_END);
        return new AccountDetailsPageLight();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(accountsBtn));
    }
}
