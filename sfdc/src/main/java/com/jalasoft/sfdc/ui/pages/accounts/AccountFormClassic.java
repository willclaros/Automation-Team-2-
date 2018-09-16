package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.TimeoutException;
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

    @FindBy(xpath = "//*[@title='Edit']" )
    private WebElement editBtn;

    @FindBy(xpath = "//*[@class='dialogClose']")
    private WebElement exitBtn;

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
        return new AccountDetailsPageClassic();
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
        driverTools.clickElement(editBtn);
        driverTools.clearTextField(nameAccountTxtBox);
        driverTools.setInputField(nameAccountTxtBox, account.getAccountName());
        driverTools.clearTextField(phoneTxtBox);
        driverTools.setInputField(phoneTxtBox, account.getPhone());
        driverTools.clearTextField(faxTxtBox);
        driverTools.setInputField(faxTxtBox, account.getFax());
        driverTools.clearTextField(numberAccountTxtBox);
        driverTools.setInputField(numberAccountTxtBox, account.getAccountNumber());
        driverTools.clearTextField(tickerTxtBox);
        driverTools.setInputField(tickerTxtBox, account.getTicker());
        driverTools.clickElement(saveBtn);
        account.setId(getUrlCurrent(driver.getCurrentUrl()));
        return  new AccountDetailsPageClassic();
    }

    private String getUrlCurrent(String currentUrl){
        String[] currentUrlList = currentUrl.split("/");
        String idUrl = currentUrlList[currentUrlList.length - 1];
        return idUrl;
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(nameAccountTxtBox));
    }
}