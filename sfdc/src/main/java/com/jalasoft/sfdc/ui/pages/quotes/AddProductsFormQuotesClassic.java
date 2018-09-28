package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.entities.QuoteLineItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductsFormQuotesClassic extends AddProductsFormQuotes {

    @FindBy (css = ".btn[title='Select']")
    private WebElement selectBtn;

    @FindBy( xpath = "//input[contains(@id,'UnitPrice')]")
    private WebElement setPriceFieldBtn;

    @FindBy( xpath = "//input[contains(@id,'Quantity')]")
    private WebElement setQuantityFieldBtn;

    @FindBy( xpath = "//input[@id='save_filter_PricebookEntry']")
    private WebElement searchBtn;

    @FindBy( css = ".btn[title='Save']")
    private WebElement saveBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
    }

    @Override
    public QuotesDetailPage fillDataProducts(Product product, QuoteLineItems quoteLineItems) {
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        driver.findElement(By.xpath("//span[text()= '"+product.getProductName()+"']/../../../../child::td//input")).click();
        driverTools.clickElement(selectBtn);
        wait.until(ExpectedConditions.visibilityOf(setPriceFieldBtn));
        driverTools.setInputField(setPriceFieldBtn,quoteLineItems.getPrice());
        driverTools.setInputField(setQuantityFieldBtn,quoteLineItems.getQuantity());
        driverTools.clickElement(saveBtn);
        return  new QuotesDetailPageClassic();
    }
}
