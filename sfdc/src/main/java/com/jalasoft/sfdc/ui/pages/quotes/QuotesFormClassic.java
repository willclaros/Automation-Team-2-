package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPage;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuotesFormClassic extends QuotesForm {

    @FindBy(css = "input[name='Name']")
    private WebElement quoteNameTxt;

    @FindBy(css = ".btn[title='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "(//span[text()='View All'])[last()]")
    private WebElement allQuoteBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
    }

    @Override
    public QuotesDetailPage createQuote(Quote quote) {
        driverTools.setInputField(quoteNameTxt,quote.getQuoteName());
        driverTools.clickElement(saveBtn);
        quote.setId(getUrlCurrent(driver.getCurrentUrl()));
        return new QuotesDetailPageClassic();
    }

    private String getUrlCurrent(String currentUrl){
        String[] currentUrlList = currentUrl.split("/");
        String idUrl = currentUrlList[currentUrlList.length - 1];
        return idUrl;
    }
}
