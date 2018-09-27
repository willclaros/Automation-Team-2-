package com.jalasoft.sfdc.ui.pages.accounts;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountsListPageClassic class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountsListPageClassic extends AccountsListPage {

    private static String VERIFY_TEXT_INIT = "//a[text()='";
    private static String VERIFY_TEXT_END = "']";
    private static String TEXT_URL = "https://na49.salesforce.com/";

    @FindBy(xpath = "//*[@title='New']" )
    private WebElement newBtn;

    @FindBy(xpath = "//*[@class='dialogClose']" )
    private WebElement exitBtn;

    /**
     * Method to click on the buttons
     *
     * @return AccountFormClassic.
     */
    @Override
    public AccountForm createNewAccount() {
        try {
            driverTools.clickElement(exitBtn);
        } catch (TimeoutException e) {
        }
        driverTools.clickElement(newBtn);
        return new AccountFormClassic();
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
        driver.navigate().to(TEXT_URL+account.getId());
        return new AccountDetailsPageClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }
}
