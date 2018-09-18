package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class AccountDetailsPageLight extends AccountDetailsPage {


    @FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement nameDetailsLbl;

    @FindBy(css = "a[title='Details']")
    private WebElement DetailsBtn;

    @FindBy(css = "a[title='Related']")
    private WebElement relatedBtn;

    //span[text()='Phone']/parent::div/following-sibling::div
    @FindBy(xpath = "//span[text()='Phone']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement phoneLbl;

    //span[text()='Fax']/parent::div/following-sibling::div/child::span/child::span
    @FindBy(xpath = "//span[text()='Fax']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement faxLbl;

    @FindBy(xpath = "//span[text()='Account Number']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement numberAccountLbl;

    @FindBy(xpath = "//span[text()='Website']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement webSiteLbl;

    @FindBy(xpath = "//span[text()='Ticker Symbol']/parent::div/following-sibling::div/child::span/child::span")
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
        driverTools.clickElement(DetailsBtn);
        assertEquals(nameDetailsLbl.getText(),account.getAccountName());
        assertEquals(phoneLbl.getText(),account.getPhone());
        assertEquals(faxLbl.getText(),account.getFax());
        assertEquals(numberAccountLbl.getText(),account.getAccountNumber());
        assertEquals(webSiteLbl.getText(),account.getWebSite());
    }

    @Override
    public void VerifyEditAccount(Account account) {
//        wait.until(ExpectedConditions.visibilityOf(relatedBtn));
//        driverTools.clickElement(DetailsBtn);
        assertEquals(nameDetailsLbl.getText(),account.getAccountName());
        assertEquals(phoneLbl.getText(),account.getPhone());
        assertEquals(faxLbl.getText(),account.getFax());
        assertEquals(numberAccountLbl.getText(),account.getAccountNumber());
        assertEquals(tickerLbl.getText(),account.getTicker());
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

        wait.until(ExpectedConditions.visibilityOf(DetailsBtn));
    }

}
