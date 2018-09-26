package com.jalasoft.sfdc.ui.pages.opportunity;

import com.jalasoft.sfdc.entities.Opportunity;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class OpportunityForm extends BasePage {
    /**
     * Abstract method that performs the setting of information of the fields of the form.
     *
     * @param opportunity value of the field to be set.
     */
    public abstract OpportunityDetailPage setFormOpportunity(Opportunity opportunity);
}
