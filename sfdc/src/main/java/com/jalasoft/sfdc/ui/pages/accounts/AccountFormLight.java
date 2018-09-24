package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * AccountFormLight class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountFormLight extends AccountForm {

    @FindBy(xpath = "//*[@class='input uiInput uiInputText uiInput--default uiInput--input']" )
    private WebElement nameAccountTxtBox;

    @FindBy(css = ".slds-button[title|='Save']" )
    private WebElement saveBtn;

    @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input" )
    private WebElement phoneTxtBox;

    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input" )
    private WebElement faxTxtBox;

    @FindBy(xpath = "//span[text()='Account Number']/parent::label/following-sibling::input" )
    private WebElement numberAccountTxtBox;

    @FindBy(xpath = "//span[text()='Website']/parent::label/following-sibling::input" )
    private WebElement webSiteTxtBox;

    @FindBy(xpath = "//span[text()='Account Site']/parent::label/following-sibling::input" )
    private WebElement siteAccountTxtBox;

    @FindBy(xpath = "//span[text()='Ticker Symbol']/parent::label/following-sibling::input" )
    private WebElement tickerTxtBox;

    @FindBy(xpath = "//span[text()='Employees']/parent::label/following-sibling::input" )
    private WebElement employeeTxtBox;

    @FindBy(xpath = "//span[text()='Annual Revenue']/parent::label/following-sibling::input" )
    private WebElement annualRevenueTxtBox;

    @FindBy(xpath = "//span[text()='SIC Code']/parent::label/following-sibling::input" )
    private WebElement sicCodeTxtBox;

    @FindBy(xpath = "//span[text()='Billing Street']/parent::label/following-sibling::textarea" )
    private WebElement billingStreeTxtBox;

    @FindBy(xpath = "//span[text()='Billing City']/parent::label/following-sibling::input" )
    private WebElement billingCityTxtBox;

    @FindBy(xpath = "//span[text()='Billing State/Province']/parent::label/following-sibling::input" )
    private WebElement billingStateTxtBox;

    @FindBy(xpath = "//span[text()='Billing Zip/Postal Code']/parent::label/following-sibling::input" )
    private WebElement billingZipTxtBox;

    @FindBy(xpath = "//span[text()='Billing Country']/parent::label/following-sibling::input" )
    private WebElement billingCountryTxtBox;

    @FindBy(xpath = "//span[text()='Shipping Street']/parent::label/following-sibling::textarea" )
    private WebElement shippingStreetTxtBox;

    @FindBy(xpath = "//span[text()='Shipping City']/parent::label/following-sibling::input" )
    private WebElement shippingCityTxtBox;

    @FindBy(xpath = "//span[text()='Shipping State/Province']/parent::label/following-sibling::input" )
    private WebElement shippingStateTxtBox;

    @FindBy(xpath = "//span[text()='Shipping Zip/Postal Code']/parent::label/following-sibling::input" )
    private WebElement shippingZipTxtBox;

    @FindBy(xpath = "//span[text()='Shipping Country']/parent::label/following-sibling::input" )
    private WebElement shippingCountryTxtBox;

    @FindBy(xpath = "//span[text()='SLA Expiration Date']/parent::label/following-sibling::div/child::input")
    private WebElement slaExpirationTxtBox;

    @FindBy(xpath = "//span[text()='SLA Serial Number']/parent::label/following-sibling::input" )
    private WebElement slaSerialNumberTxtBox;

    @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea" )
    private WebElement descriptionTxtBox;

    @FindBy(xpath = "//span[text()='Number of Locations']/parent::label/following-sibling::input" )
    private WebElement numberOfLocationsTxtBox;

    @FindBy(xpath = "//span[text()='Rating']/parent::span/following-sibling::div/child::div/child::div/child::div/child::a" )
    private WebElement ratingLstBox;
//    Select ratingLstBoxSelect;
//    ratingLstBoxSelect = new Select(ratingLstBox);
//    ratingLstBoxSelect.selectByVisibleText(account.getRating());
    @FindBy(xpath = "//*[text()='Details']" )
    private WebElement detailsBtn;

    @FindBy(xpath = "//a[@title='Edit']" )
    private WebElement editBtn;

    @FindBy(xpath = "//*[text()='Account Name']/parent::label/following-sibling::input" )
    private WebElement editNameTxtBox;

    @FindBy(xpath = "//*[text()='Phone']/parent::label/following-sibling::input" )
    private WebElement editPhoneTxtBox;

    @FindBy(xpath = "//*[text()='Fax']/parent::label/following-sibling::input" )
    private WebElement editFaxTxtBox;

    @FindBy(xpath = "//*[text()='Account Number']/parent::label/following-sibling::input" )
    private WebElement editNumberAccountTxtBox;

    @FindBy(xpath = "//*[text()='Ticker Symbol']/parent::label/following-sibling::input" )
    private WebElement editTickerTxtBox;

    @FindBy(xpath = "//a[@title='Show 7 more actions']")
    private WebElement moreBtn;


    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(nameAccountTxtBox));
    }

    /**
     * Method to enter the values ​​from the entity
     *
     * @param account entity
     *
     * @return page Accounts Details Classic
     */
    @Override
    public AccountDetailsPage fillAccountForm(Account account) {
        driverTools.setInputField(nameAccountTxtBox, account.getAccountName());
        driverTools.setInputField(numberAccountTxtBox, account.getAccountNumber());
        driverTools.setInputField(phoneTxtBox, account.getPhone());
        driverTools.setInputField(faxTxtBox, account.getFax());
        driverTools.setInputField(tickerTxtBox, account.getTicker());
        driverTools.clickElement(saveBtn);
        return new AccountDetailsPageLight();
    }

    /**
     *
     Method to change the values ​​that are edited for account
     *
     * @param account entity
     *
     * @return page Accounts Details Classic
     */
    @Override
    public AccountDetailsPage editAccountData(Account account) {
        driverTools.clickElement(moreBtn);
        driverTools.clickElement(editBtn);
        driverTools.clearTextField(editNameTxtBox);
        driverTools.setInputField(editNameTxtBox, account.getAccountName());
        driverTools.clearTextField(editPhoneTxtBox);
        driverTools.setInputField(editPhoneTxtBox, account.getPhone());
        driverTools.clearTextField(editFaxTxtBox);
        driverTools.setInputField(editFaxTxtBox, account.getFax());
        driverTools.clearTextField(editNumberAccountTxtBox);
        driverTools.setInputField(editNumberAccountTxtBox, account.getAccountNumber());
        driverTools.clearTextField(editTickerTxtBox);
        driverTools.setInputField(editTickerTxtBox, account.getTicker());
        driverTools.clickElement(saveBtn);
        try {
            wait.until(ExpectedConditions.invisibilityOf(saveBtn));
        } catch (TimeoutException e) {
            System.out.println("catch timeout");
        }
        account.setId(getUrlCurrent(driver.getCurrentUrl()));
        return  new AccountDetailsPageLight();
    }
    private String getUrlCurrent(String currentUrl){
        String[] currentUrlList = currentUrl.split("/");
        String idUrl = currentUrlList[currentUrlList.length - 2];
        return idUrl;
    }
}
