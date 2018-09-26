package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductsFormQuotesClassic extends AddProductsFormQuotes {

    @FindBy (css = ".btn[title='Select']")
    private WebElement selectBtn;

    @FindBy( css = "input[id='UnitPrice01u5A00000tgr4i']")
    private WebElement setPriceFieldBtn;

    @FindBy( css = "input[id='Quantity01u5A00000tgr4i']")
    private WebElement setQuantityFieldBtn;


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public QuotesDetailPage fillDataProducts(Product product) {
        driverTools.clickElement((By.xpath("//span[text()= '"+product.getProductName()+"']/../../../../child::td/child::div/child::input")));
        driverTools.clickElement(selectBtn);
        wait.until(ExpectedConditions.invisibilityOf(selectBtn));
        driverTools.setInputField(setPriceFieldBtn,"10");
        driverTools.setInputField(setQuantityFieldBtn,"20");
        return  new QuotesDetailPageClassic();
    }
}
