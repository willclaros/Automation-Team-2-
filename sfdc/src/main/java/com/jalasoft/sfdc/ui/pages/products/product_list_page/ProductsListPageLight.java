package com.jalasoft.sfdc.ui.pages.products.product_list_page;

import com.jalasoft.sfdc.ui.pages.products.new_page_product.NewPageProductsLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsListPageLight extends ProductsListPage {

    @FindBy(css = ".forceActionLink")
    private WebElement newProduct;

    public NewPageProductsLight createNewProduct() {
        wait.until(ExpectedConditions.visibilityOf(newProduct));
        driverTools.clickElement(newProduct);
        return new NewPageProductsLight();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}
