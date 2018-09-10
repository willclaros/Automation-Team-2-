package com.jalasoft.sfdc.ui.pages.products.product_list_page;

import com.jalasoft.sfdc.ui.pages.products.new_page_product.NewPageProducts;
import com.jalasoft.sfdc.ui.pages.products.new_page_product.NewPageProductsClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsListPageClassic extends ProductsListPage{

    @FindBy(xpath = "//*[@value = ' New ']")
    private WebElement productBtn;

    @FindBy(xpath = "//*[@class='dialogClose']")
    private WebElement exitBtn;

    @Override
    public NewPageProducts createNewProduct() {
        wait.until(ExpectedConditions.visibilityOf(productBtn));
        driverTools.clickElement(exitBtn);
        driverTools.clickElement(productBtn);
        return new NewPageProductsClassic();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}
