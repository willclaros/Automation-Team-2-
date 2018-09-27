package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductAddStandardPriceClassic extends ProductAddStandardPrice {

    @FindBy(xpath = "//input[@title='Unit Price']")
    private WebElement unitPriceTxt;

    @FindBy(xpath = "//input[@title='Save']")
    private WebElement saveBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public ProductsDetailPage goToDetailPage() {
        driverTools.setInputField(unitPriceTxt,"10");
        driverTools.clickElement(saveBtn);
        return new ProductsDetailPageClassic();
    }
}
