package com.jalasoft.sfdc.ui.pages.pricebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceBookListPageLight extends PriceBookListPage{
    @FindBy(css = ".forceActionLink")
    private WebElement newPriceBook;

    public NewPagePriceBooksLight createNewPriceBook() {
        wait.until(ExpectedConditions.visibilityOf(newPriceBook));
        driverTools.clickElement(newPriceBook);
        return new NewPagePriceBooksLight();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }


    @Override
    public NewPagePriceBooksLight createNewPriceBooks() {
        return null;
    }
}
