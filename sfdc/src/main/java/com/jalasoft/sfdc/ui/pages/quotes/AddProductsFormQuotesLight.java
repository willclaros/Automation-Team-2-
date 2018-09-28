package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.entities.QuoteLineItems;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductsFormQuotesLight extends AddProductsFormQuotes {

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextBtn;

    @FindBy( xpath = "//th[@scope='row'])[1]")
    private WebElement selectProduct;

    @FindBy( xpath = "(//td[@class='slds-cell-edit lockTrigger cellContainer']/following-sibling::td/child::span/child::span/child::button)[1]")
    private WebElement clickPriceFieldBtn;

    @FindBy( css = ".uiInputCurrency")
    private WebElement setPriceFieldBtn;

    @FindBy( xpath = "(//td[@class='slds-cell-edit lockTrigger cellContainer']/following-sibling::td/child::span/child::span/child::button)[2]")
    private WebElement clickQuantityFieldBtn;

    @FindBy( css = ".slds-grow.input")
    private WebElement setQuantityFieldBtn;
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public QuotesDetailPage fillDataProducts(Product product, QuoteLineItems quoteLineItems) {
        driverTools.clickElement(selectProduct);
        driverTools.clickElement(nextBtn);
        wait.until(ExpectedConditions.invisibilityOf(nextBtn));
        driverTools.clickElement(clickPriceFieldBtn);
        return null;
    }
}
