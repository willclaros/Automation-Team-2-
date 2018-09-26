package com.jalasoft.sfdc.ui.pages.opportunity;

import com.jalasoft.sfdc.ui.pages.quotes.QuotesForm;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunityDetailPageClassic extends OpportunityDetailPage {

    @FindBy(css = ".dataCol #opp3_ileinner")
    private WebElement opportunityNameTxt;

    @FindBy(css = ".dataCol #opp9_ileinner")
    private WebElement closeDateTxt;

    @FindBy(css = ".dataCol #opp11_ileinner")
    private WebElement stageTxt;

    @FindBy(css = ".btn[value='New Quote']")
    private WebElement newQuoteBtn;

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(opportunityNameTxt));
    }

    /**
     * Method that is responsible for obtaining text of a WebElement.
     *
     * @return returns the text of the WebElement.
     */
    @Override
    public String getNameTxt() {
        return opportunityNameTxt.getText();
    }

    @Override
    public void goToDetails() {

    }

    @Override
    public QuotesForm goToNewQuotes() {
        driverTools.clickElement(newQuoteBtn);
        return new QuotesFormClassic();
    }
}
