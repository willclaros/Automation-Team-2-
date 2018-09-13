package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
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

    @FindBy(xpath = "//div[@id='acc2_ileinner']")
    private WebElement nameAccountLbl;

    @FindBy(xpath = "//input[@title='Edit']")
    private WebElement DetailsBtn;

    //span[text()='Phone']/parent::div/following-sibling::div
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
        driverTools.clickElement(DetailsBtn);
        assertEquals(nameAccountLbl.getText(),account.getAccountName());
        assertEquals(phoneLbl.getText(),account.getPhone());
        assertEquals(faxLbl.getText(),account.getFax());
        assertEquals(numberAccountLbl.getText(),account.getAccountNumber());
        assertEquals(tickerLbl.getText(),account.getTicker());
    }

    @Override
    public void VerifyEditAccount(Account account) {
        assertEquals(nameAccountLbl.getText(),account.getAccountName());
        assertEquals(phoneLbl.getText(),account.getPhone());
        assertEquals(faxLbl.getText(),account.getFax());
        assertEquals(numberAccountLbl.getText(),account.getAccountNumber());
        assertEquals(tickerLbl.getText(),account.getTicker());
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(nameAccountLbl));
    }

}