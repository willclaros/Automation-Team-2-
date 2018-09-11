package com.jalasoft.sfdc.ui.pages.products.new_page_product;

import com.jalasoft.sfdc.ui.pages.products.product_detail_page.ProductsDetailPage;
import com.jalasoft.sfdc.ui.pages.products.product_detail_page.ProductsDetailPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPageProductsClassic extends NewPageProducts {

    //WebDriverTools webDriverTools = new WebDriverTools();
    @FindBy(xpath = "//*[@name = 'Name']")
    private WebElement nameProduct;

    @FindBy(xpath = "//*[@name = 'save']")
    private WebElement saveButton;

    @Override
    public ProductsDetailPage setFormular(String name) {
        driverTools.setInputField(nameProduct,name);
        driverTools.clickElement(saveButton);
        return new ProductsDetailPageClassic();
    }

    @Override
    public ProductsDetailPage clickSaveBtn() {
        //driverTools.clickElement(saveButton);
        return new ProductsDetailPageClassic();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
