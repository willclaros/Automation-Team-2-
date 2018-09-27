package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.ui.pages.products.ProductsForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuotesDetailPageClassic extends  QuotesDetailPage {


    @FindBy(css = ".btn[value='Add Line Item']")
    private WebElement addLineItemBtn;

    @FindBy(css = "#p1")
    private WebElement listCmbBox;

    @FindBy(css = ".btn[title='Save']")
    private WebElement saveBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @Override
    public AddProductsFormQuotes goToAddProducts() {
        driverTools.clickElement(addLineItemBtn);
        wait.until(ExpectedConditions.invisibilityOf(addLineItemBtn));
        chooseProductFamilyClassicCmbBox("Standard");
        driverTools.clickElement(saveBtn);
        return new AddProductsFormQuotesClassic();
    }

    /**
     * Method that selects an element of the combo box and has as input a string.
     *
     * @param productFamily is a string that represents the option of the combo box that is required to select.
     */
    public QuotesDetailPageClassic chooseProductFamilyClassicCmbBox(final String productFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(listCmbBox));
        driverTools.clickElement(listCmbBox);
        if (!productFamily.isEmpty()) {
            driverTools.clickElement(driver.findElement(By.cssSelector("[value=" + productFamily + "]")));
        }
        return this;
    }
}
