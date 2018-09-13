package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = "(//*[@class=' input'])[1]" )
    private WebElement phoneTxtBox;

    @FindBy(xpath = "(//*[@type='tel'])[2]" )
    private WebElement faxTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[3]" )
    private WebElement numberAccountTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[4]" )
    private WebElement webSiteTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[5]" )
    private WebElement siteAccountTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[6]" )
    private WebElement tickerTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[7]" )
    private WebElement employeeTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[8]" )
    private WebElement annualRevenueTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[9]" )
    private WebElement sicCodeTxtBox;

    @FindBy(xpath = "(//*[@class='street compoundTLRadius compoundTRRadius compoundBorderBottom textarea'])[1]" )
    private WebElement billingStreeTxtBox;

    @FindBy(xpath = "(//*[@class='city compoundBorderBottom compoundBorderRight input'])[1]" )
    private WebElement billingCityTxtBox;

    @FindBy(xpath = "(//*[@class='state compoundBorderBottom input'])[1]" )
    private WebElement billingStateTxtBox;

    @FindBy(xpath = "(//*[@class='postalCode compoundBLRadius compoundBorderRight input'])[1]" )
    private WebElement billingZipTxtBox;

    @FindBy(xpath = "(//*[@class='country compoundBRRadius input'])[1]" )
    private WebElement billingCountryTxtBox;

    @FindBy(xpath = "(//*[@class='street compoundTLRadius compoundTRRadius compoundBorderBottom textarea'])[2]" )
    private WebElement shippingStreetTxtBox;

    @FindBy(xpath = "(//*[@class='city compoundBorderBottom compoundBorderRight input'])[2]" )
    private WebElement shippingCityTxtBox;

    @FindBy(xpath = "(//*[@class='state compoundBorderBottom input'])[2]" )
    private WebElement shippingStateTxtBox;

    @FindBy(xpath = "(//*[@class='postalCode compoundBLRadius compoundBorderRight input'])[2]" )
    private WebElement shippingZipTxtBox;

    @FindBy(xpath = "(//*[@class='country compoundBRRadius input'])[2]" )
    private WebElement shippingCountryTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[11] ")
    private WebElement slaExpirationTxtBox;

    @FindBy(xpath = "(//*[@class=' input'])[12]" )
    private WebElement slaSerialNumberTxtBox;

    @FindBy(xpath = "(//*[@class=' textarea'])" )
    private WebElement descriptionTxtBox;

    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(nameAccountTxtBox));
    }

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
        return new AccountDetailsPageLight();
    }

}
