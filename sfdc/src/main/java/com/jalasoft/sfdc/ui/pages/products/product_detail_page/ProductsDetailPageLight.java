package com.jalasoft.sfdc.ui.pages.products.product_detail_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsDetailPageLight extends ProductsDetailPage{

    @FindBy(xpath = "//*[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']//child::span")
    private WebElement product;

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @Override
    public String verifyCreateProduct() {
        return product.getText();
    }
}
