package com.jalasoft.sfdc.ui.pages.opportunity;

import com.jalasoft.sfdc.ui.pages.quotes.QuotesForm;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormClassic;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunityDetailPageLight extends OpportunityDetailPage {

    @FindBy(xpath = "//span[text()='Opportunity Name']/parent::div/following-sibling::div/child::span/child::span[@class='uiOutputText']")
    private WebElement opportunityNameTxt;

    @FindBy(xpath = "//span[text()='Close Date']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement closeDateTxt;

    @FindBy(xpath = "//span[text()='Stage']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement stageTxt;

    @FindBy(xpath = "//span[text()='Details']")
    private WebElement detailBtn;

    @FindBy(css = ".uiMenuItem a[title='New Quote']")
    private WebElement newQuoteBtn;

    @FindBy (css =".oneActionsDropDown a[title='Show one more action']")
    private WebElement moreQouteBtn;


    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(detailBtn));
    }

    @Override
    public String getNameTxt() {
        return opportunityNameTxt.getText();
    }

    @Override
    public void goToDetails(){
        wait.until(ExpectedConditions.visibilityOf(detailBtn));
        driverTools.clickElement(detailBtn);
    }

    @Override
    public QuotesForm goToNewQuotes() {
        driverTools.clickElement(moreQouteBtn);
        driverTools.clickElement(newQuoteBtn);
        return new QuotesFormLight();
    }
}
