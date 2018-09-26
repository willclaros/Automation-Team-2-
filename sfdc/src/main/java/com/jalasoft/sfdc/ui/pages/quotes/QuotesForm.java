package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.opportunity.OpportunityDetailPage;

public abstract class QuotesForm  extends BasePage {

    public abstract QuotesDetailPage createQuote(Quote qoute);
}
