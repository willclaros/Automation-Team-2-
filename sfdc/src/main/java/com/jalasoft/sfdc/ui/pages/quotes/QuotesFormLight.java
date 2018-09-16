package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPage;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPageLight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesFormLight extends QuotesForm {

   @FindBy(css = ".input[aria-required='true']")
   private WebElement quoteNameTxt;

    @FindBy(css = ".forceActionButton[title='Save']")
    private WebElement saveBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public QuotesDetailPage createQuote(Quote quote) {
        driverTools.setInputField(quoteNameTxt,quote.getQuoteName());
        driverTools.clickElement(saveBtn);
        driverTools.clickElement((By.xpath("//a[text()= '"+quote.getQuoteName()+"']")));
        return new QuotesDetailPageLight();
    }
}
