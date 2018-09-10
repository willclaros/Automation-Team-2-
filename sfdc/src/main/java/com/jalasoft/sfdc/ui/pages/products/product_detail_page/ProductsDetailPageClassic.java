package com.jalasoft.sfdc.ui.pages.products.product_detail_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsDetailPageClassic extends ProductsDetailPage {

    @FindBy(css = ".pageDescription")
    private WebElement productDescription;

    @Override
    public String verifyCreateProduct() {
        wait.until(ExpectedConditions.visibilityOf(productDescription));
        return productDescription.getText();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}
