package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class AccountDetailsPageLight extends AccountDetailsPage {


    @FindBy(xpath = "(//div[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']//child::span)[1]")
    private WebElement nameDetailsLbl;

    @FindBy(xpath = "//span[text()='Details']")
    private WebElement DetailsBtn;

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
        driverTools.clickElement(DetailsBtn);
         assertEquals(nameDetailsLbl.getText(),account.getAccountName());
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

        wait.until(ExpectedConditions.visibilityOf(nameDetailsLbl));
    }

}
