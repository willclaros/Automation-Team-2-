package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountDetailsPageClassic class.
 *
 * @author Cesar Calvi Lujan
 * @since 9/3/2018
 */

public class AccountDetailsPageClassic extends AccountDetailsPage {

    private static final String NAME_ACCOUNT = "//*[@class='topName']";


    @FindBy(xpath = NAME_ACCOUNT)
    private WebElement nameDetailsLbl;

    /**
     * Take the webElement chain.
     *
     * @return the text of the webElement.
     */
    @Override
    public String getNameAccount() {

        wait.until(ExpectedConditions.visibilityOf(nameDetailsLbl));
        return nameDetailsLbl.getText();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(nameDetailsLbl));
    }
}
