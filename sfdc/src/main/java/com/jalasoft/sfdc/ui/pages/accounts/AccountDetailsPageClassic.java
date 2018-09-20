package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

/**
 * AccountDetailsPageClassic class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountDetailsPageClassic extends AccountDetailsPage {

    private BasePage basePage;

    @FindBy(xpath = "//div[@id='acc2_ileinner']")
    private WebElement nameAccountLbl;

    @FindBy(xpath = "//input[@title='Edit']")
    private WebElement DetailsBtn;

    @FindBy(xpath = "//input[@title='Delete']")
    private WebElement deleteBtn;

    @FindBy(xpath = "//div[@id='acc10_ileinner']")
    private WebElement phoneLbl;

    //span[text()='Fax']/parent::div/following-sibling::div/child::span/child::span
    @FindBy(xpath = "//div[@id='acc11_ileinner']")
    private WebElement faxLbl;

    @FindBy(xpath = "//div[@id='acc5_ileinner']")
    private WebElement numberAccountLbl;

    @FindBy(xpath = "//div[@id='acc12_ileinner']")
    private WebElement webSiteLbl;

    @FindBy(xpath = "//div[@id='acc13_ileinner']")
    private WebElement tickerLbl;


    /**
     * Take the webElement chain.
     *
     * @return the text of the webElement.
     */
    @Override
    public void verifyDataAccount(Account account) {
    }

    /**
     * Method to get account name
     *
     * @return String of Account name
     */
    @Override
    public String getAccountName() {
        String nameAux = nameAccountLbl.getText();
        return nameAux.replace(" [View Hierarchy]", "");
    }

    /**
     * Method to get account number
     *
     * @return String of Account number
     */
    @Override
    public String getAccountNumber() {
        return numberAccountLbl.getText();
    }

    /**
     * Method to get account phone
     *
     * @return String of Account phone
     */
    @Override
    public String getAccountPhone() {
        return phoneLbl.getText();
    }

    /**
     * Method to get account fax
     *
     * @return String of Account fax
     */
    @Override
    public String getAccountFax() {
        return faxLbl.getText();
    }

    /**
     * Method to get account ticker
     *
     * @return String of Account ticker
     */
    @Override
    public String getAccountTicker() {
        return tickerLbl.getText();
    }

    /**
     * Method to get details page
     *
     * @param account entities
     */
    @Override
    public void goToDetailsTab(Account account) {

    }

    /**
     * method to inspect the item is displayed
     *
     * @param account entities
     *
     * @return the element if it is visible
     */
    @Override
    public boolean isAccountNameDisplayed(Account account) {
        driverTools.isElementDisplayed(nameAccountLbl);
        return driverTools.isElementDisplayed(nameAccountLbl);
    }

    /**
     * method to inspect the item is displayed
     *
     * @param account entities
     *
     * @return the element if it is visible
     */
    @Override
    public boolean isAccountNumberDisplayed(Account account) {
        return driverTools.isElementDisplayed(numberAccountLbl);
    }

    /**
     * method to inspect the item is displayed
     *
     * @param account entities
     *
     * @return the element if it is visible
     */
    @Override
    public boolean isAccountFaxDisplayed(Account account) {
        return driverTools.isElementDisplayed(faxLbl);
    }

    /**
     * method to inspect the item is displayed
     *
     * @param account entities
     *
     * @return the element if it is visible
     */
    @Override
    public boolean isAccountTickerDisplayed(Account account) {
        return driverTools.isElementDisplayed(tickerLbl);
    }

    /**
     * method to inspect the item is displayed
     *
     * @param account entities
     *
     * @return the element if it is visible
     */
    @Override
    public boolean isAccountPhoneDisplayed(Account account) {
        return driverTools.isElementDisplayed(phoneLbl);
    }

    /**
     * method for access to AcccountsListClassic
     *
     * @param account entities
     *
     * @return the pague Acccounts ListClassic
     */
    @Override
    public AccountsListPage deleteAccount(Account account) {
        driverTools.clickElement(deleteBtn);
        acceptAlertDialog();
        return new AccountsListPageClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(nameAccountLbl));
    }

}