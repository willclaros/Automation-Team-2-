package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPage;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesFormClassic extends QuotesForm {

    @FindBy(css = "input[name='Name']")
    private WebElement quoteNameTxt;

    @FindBy(css = ".btn[title='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "(//span[text()='View All'])[last()]")
    private WebElement allQuoteBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public QuotesDetailPage createQuote(Quote quote) {
        driverTools.setInputField(quoteNameTxt,quote.getQuoteName());
        driverTools.clickElement(saveBtn);
        return new QuotesDetailPageClassic();
    }
}
