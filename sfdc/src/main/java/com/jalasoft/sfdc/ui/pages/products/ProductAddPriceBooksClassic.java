package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAddPriceBooksClassic extends ProductAddPriceBooks {

    @FindBy(xpath = "//*[@title='Select Standard']")
    private WebElement selectChkBox;

    @FindBy(xpath = "//input[@title='Select']")
    private WebElement selectBtn;

    @FindBy(xpath = "//input[@title='List Price 1']")
    private WebElement priceListTxt;

    @FindBy(xpath = "//input[@title='Save']")
    private WebElement saveBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public ProductsDetailPage filldataPriceBook() {
        selectChkBox.click();
        driverTools.clickElement(selectBtn);
        driverTools.sleepMilliSeconds(2000);
        driverTools.setInputField(priceListTxt,"12");
        driverTools.clickElement(saveBtn);
        return new ProductsDetailPageClassic();
    }
}
