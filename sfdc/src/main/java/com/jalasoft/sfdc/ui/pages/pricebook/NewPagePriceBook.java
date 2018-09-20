package com.jalasoft.sfdc.ui.pages.pricebook;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class NewPagePriceBook extends BasePage {

    public abstract PriceBookDetailPage setForm(String name, String description, String active);
    public abstract PriceBookDetailPage clickSaveBtn();
}
