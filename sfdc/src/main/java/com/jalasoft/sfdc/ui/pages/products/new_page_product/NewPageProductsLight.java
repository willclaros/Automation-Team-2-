package com.jalasoft.sfdc.ui.pages.products.new_page_product;

import com.jalasoft.sfdc.ui.pages.products.product_detail_page.ProductsDetailPage;
import com.jalasoft.sfdc.ui.pages.products.product_detail_page.ProductsDetailPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPageProductsLight extends NewPageProducts {

    //WebDriverTools webDriverTools = new WebDriverTools();
    @FindBy(xpath = "//*[@aria-required='true']")
    private WebElement nameProduct;

    @FindBy(xpath = "//div[contains(@class,'forceModalActionContainer--footerAction forceModalActionContainer')]//button[3]")
    private WebElement saveButton;

    @Override
    public ProductsDetailPage setFormular(String name) {
        driverTools.setInputField(nameProduct,name);
        driverTools.clickElement(saveButton);
        return new ProductsDetailPageLight();
    }

    @Override
    public ProductsDetailPage clickSaveBtn() {
        //driverTools.clickElement(saveButton);
        return new ProductsDetailPageLight();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}
