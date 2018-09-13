package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * AccountFormClassic class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountFormClassic extends AccountForm {

    @FindBy(xpath = "//*[@name='acc2']" )
    private WebElement nameAccountTxtBox ;

    @FindBy(xpath = "//*[@name='save']" )
    private WebElement saveBtn;

    @FindBy(xpath = "//*[@name='acc5']" )
    private WebElement numberAccountTxtBox;

    @FindBy(xpath = "//*[@name='acc23']" )
    private WebElement siteAccountTxtBox;

    @FindBy(xpath = "//*[@name='acc8']" )
    private WebElement annualRevenueTxtBox;

    @FindBy(xpath = "//*[@name='acc10']" )
    private WebElement phoneTxtBox;

    @FindBy(xpath = "//*[@name='acc11']" )
    private WebElement faxTxtBox;

    @FindBy(xpath = "//*[@name='acc12']" )
    private WebElement webSiteTxtBox;

    @FindBy(xpath = "//*[@name='acc13']" )
    private WebElement tickerTxtBox;

    @FindBy(xpath = "//*[@name='acc15']" )
    private WebElement employeeTxtBox;

    @FindBy(xpath = "//*[@name='acc16']" )
    private WebElement sicCodeTxtBox;

    @FindBy(xpath = "//*[@name='acc17street']" )
    private WebElement billingStreeTxtBox;

    @FindBy(xpath = "//*[@name='acc17city']" )
    private WebElement billingCityTxtBox;

    @FindBy(xpath = "//*[@name='acc17state']" )
    private WebElement billingStateTxtBox;

    @FindBy(xpath = "//*[@name='acc17zip']" )
    private WebElement billingZipTxtBox;

    @FindBy(xpath = "//*[@name='acc17country']" )
    private WebElement billingCountryTxtBox;

    @FindBy(xpath = "//*[@name='acc18street']" )
    private WebElement shippingStreetTxtBox;

    @FindBy(xpath = "//*[@name='acc18city']" )
    private WebElement shippingCityTxtBox;

    @FindBy(xpath = "//*[@name='acc18state']" )
    private WebElement shippingStateTxtBox;

    @FindBy(xpath = "//*[@name='acc18zip']" )
    private WebElement shippingZipTxtBox;

    @FindBy(xpath = "//*[@name='acc18country']" )
    private WebElement shippingCountryTxtBox;

    @FindBy(xpath = "//*[@name='00N0b000007F8xQ']" )
    private WebElement slaExpirationTxtBox;

    @FindBy(xpath = "//*[@name='00N0b000007F8xR']" )
    private WebElement slaSerialNumberTxtBox;

    @FindBy(xpath = "//*[@name='acc20']" )
    private WebElement descriptionTxtBox;


    /**
     * Method to access the account details page
     *
     * @return
     */
    @Override
    public AccountDetailsPage fillAccountForm(Account account) {
        driverTools.setInputField(nameAccountTxtBox, account.getAccountName());
        driverTools.setInputField(numberAccountTxtBox, account.getAccountNumber());
        driverTools.setInputField(siteAccountTxtBox, account.getAccountSite());
        driverTools.setInputField(annualRevenueTxtBox, account.getAnnualRevenue());
        driverTools.setInputField(phoneTxtBox, account.getPhone());
        driverTools.setInputField(faxTxtBox, account.getFax());
        driverTools.setInputField(webSiteTxtBox, account.getWebSite());
        driverTools.setInputField(tickerTxtBox, account.getTicker());
        driverTools.setInputField(employeeTxtBox, account.getEmployees());
        driverTools.setInputField(sicCodeTxtBox, account.getSicCode());
        driverTools.setInputField(billingStreeTxtBox, account.getBillingStreet());
        driverTools.setInputField(billingCityTxtBox, account.getBillingCity());
        driverTools.setInputField(billingStateTxtBox, account.getBillingState());
        driverTools.setInputField(billingZipTxtBox, account.getBillingZip());
        driverTools.setInputField(billingCountryTxtBox, account.getBillingCountry());
        driverTools.setInputField(shippingStreetTxtBox, account.getShippingStreet());
        driverTools.setInputField(shippingCityTxtBox, account.getShippingCity());
        driverTools.setInputField(shippingStateTxtBox, account.getShippingState());
        driverTools.setInputField(shippingZipTxtBox, account.getShippingZip());
        driverTools.setInputField(shippingCountryTxtBox, account.getShippingCountry());
        driverTools.setInputField(slaExpirationTxtBox, account.getSlaExpirationDate());
        driverTools.setInputField(slaSerialNumberTxtBox, account.getSlaSerialNumber());
        driverTools.setInputField(descriptionTxtBox, account.getDescription());
        driverTools.clickElement(saveBtn);
        return new AccountDetailsPageClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(nameAccountTxtBox));
    }
}