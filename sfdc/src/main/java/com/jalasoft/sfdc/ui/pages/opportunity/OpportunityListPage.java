package com.jalasoft.sfdc.ui.pages.opportunity;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBooksForm;

public abstract class OpportunityListPage extends BasePage {
    /**
     * Abstract method that redirects us to Product form by pressing the New button.
     *
     * @return returns the Product form.
     */
    public abstract OpportunityForm clickNewBtn();
}
