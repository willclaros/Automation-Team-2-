package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertEquals;

public class  AccountDetailsPageLight extends AccountDetailsPage {


    @FindBy(xpath = "//span[contains(text(), 'Account Name')]/parent::div/following-sibling::div/span/span")
    private WebElement nameDetailsLbl;

    @FindBy(xpath = "//a[@title='Details']")
    private WebElement detailsLink;

    @FindBy(css = "a[title='Related']")
    private WebElement relatedBtn;

    @FindBy(xpath = "//span[contains(text(), 'Phone')]/parent::div/following-sibling::div/span/span")
    private WebElement phoneLbl;

    @FindBy(xpath = "//span[contains(text(), 'Fax')]/parent::div/following-sibling::div/span/span")
    private WebElement faxLbl;

    @FindBy(xpath = "//span[contains(text(), 'Account Number')]/parent::div/following-sibling::div/span/span")
    private WebElement numberAccountLbl;

    @FindBy(xpath = "//span[contains(text(), 'Website')]/parent::div/following-sibling::div/span")
    private WebElement webSiteLbl;

    @FindBy(xpath = "//span[contains(text(), 'Ticker Symbol')]/parent::div/following-sibling::div/span/span")
    private WebElement tickerLbl;

    @FindBy(xpath = "//a[@title='Show 7 more actions']")
    private WebElement moreBtn;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deleteBtn;

    @FindBy(xpath = "//button[@title='Delete']")
    private WebElement deletePopappBtn;


    /**
     * Take the webElement chain.
     *
     * @return the text of the webElement.
     */
    @Override
    public void verifyDataAccount(Account account) {
        driverTools.clickElement(detailsLink);

    }

    /**
     * Method to get account name
     *
     * @return String of Account name
     */
    @Override
    public String getAccountName() {
        return nameDetailsLbl.getText();
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
     * Method to get account Phone
     *
     * @return String of Account Phone
     */
    @Override
    public String getAccountPhone() {
        return phoneLbl.getText();
    }

    /**
     * Method to get account Fax
     *
     * @return String of Account Fax
     */
    @Override
    public String getAccountFax() {
        return faxLbl.getText();
    }

    /**
     * Method to get account Ticker
     *
     * @return String of Account Ticker
     */
    @Override
    public String getAccountTicker() {
        return tickerLbl.getText();
    }

    /**
     * Method to go to details and see if it is visible
     *
     * @param account entities
     */
    @Override
    public void goToDetailsTab(Account account) {
        if (driverTools.isElementDisplayed(
                By.xpath("//span[@class = 'title' and text()='Details']/../../a[@aria-selected='false']"))) {
            driverTools.clickElementSpanLink(detailsLink);
        }
    }

    /**
     * method to inspect the item is displayed
     *
     * @param account entities
     *
     * @return the element if it is visible
     */
    @Override
    public boolean isAccountNameDisplayed (Account account) {
        return driverTools.isElementDisplayed(By.xpath("//span[text()='Account Name']/../" +
                "following-sibling::div/span/span[text()='" + account.getAccountName() + "']"));
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
        return driverTools.isElementDisplayed(By.xpath("//span[text()='Account Number']/../" +
                "following-sibling::div/span/span[text()='" + account.getAccountNumber() + "']"));
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
        return driverTools.isElementDisplayed(By.xpath("//span[text()='Fax']/../" +
                "following-sibling::div/span/span[text()='" + account.getFax() + "']"));
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
        return driverTools.isElementDisplayed(By.xpath("//span[text()='Ticker Symbol']/../" +
                "following-sibling::div/span/span[text()='" + account.getTicker() + "']"));
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
        return driverTools.isElementDisplayed(By.xpath("//span[text()='Phone']/../" +
                "following-sibling::div/span/span[text()='" + account.getPhone() + "']"));
    }

    @Override
    public AccountsListPage deleteAccount(Account account) {
        driverTools.clickElement(moreBtn);
        driverTools.clickElement(deleteBtn);
        driverTools.clickElement(deletePopappBtn);
        return new AccountsListPageLight();
    }


    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

}
