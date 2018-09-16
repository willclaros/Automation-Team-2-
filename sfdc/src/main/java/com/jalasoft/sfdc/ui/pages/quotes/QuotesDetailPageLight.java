package com.jalasoft.sfdc.ui.pages.quotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesDetailPageLight extends QuotesDetailPage {

    @FindBy( xpath = "//th[@scope='row'])[1]")
    private WebElement selectProduct;

    @FindBy(css = ".slds-truncate[title='Add Products']")
    private WebElement addProductsBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @Override
    public AddProductsFormQuotes goToAddProducts() {
        driverTools.clickElement(addProductsBtn);
        return new AddProductsFormQuotesLight();
    }
}
