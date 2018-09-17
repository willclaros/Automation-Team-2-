/*
 * @(#)ProductsDetailPageClassic.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

/**
 * Class that has the product detail page of the classic skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsDetailPageClassic extends ProductsDetailPage {

    private static final String PRODUCT_LIST_INI = "//a[text()='";
    private static final String PRODUCT_LIST_END = "']";

    @FindBy(css = ".inlineEditWrite div[id='Name_ileinner']")
    private WebElement productNameTxt;

    @FindBy(css = ".dataCol div[id='ProductCode_ileinner']")
    private WebElement productCodeTxt;

    @FindBy(css = ".last div[id='Description_ileinner']")
    private WebElement descriptionTxt;

    @FindBy(css = ".checkImg")
    private WebElement activeChkBox;

    @FindBy(css = ".dataCol div[id='Family_ileinner']")
    private WebElement productFamilyCmbBox;

    @FindBy(css = ".btn[value*='Edit']")
    private WebElement editBtn;

    @FindBy(css = ".btn[title='Delete']")
    private WebElement deleteBtn;

    @FindBy(xpath = "//input[@title='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//input[@title='Add to Price Book']")
    private WebElement addPriceBookBtn;

    @FindBy(xpath = "//*[@class='dialogClose']" )
    private WebElement exitBtn;

    @FindBy(xpath = "(//a[@title='Close'])[last()]")
    private WebElement adExitBtn;

    @Override
    public ProductAddStandardPrice gotoAddStandardPrice() {
        if (exitBtn.isDisplayed()){
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickElement(addBtn);
        return new ProductAddStandardPriceClassic();
    }

    @Override
    public ProductAddPriceBooks gotoAddPriceBook() {
        wait.until(ExpectedConditions.visibilityOf(addPriceBookBtn));
        driverTools.clickElement(addPriceBookBtn);
        return new ProductAddPriceBooksClassic();
    }

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productNameTxt));
    }

    /**
     * Method that is responsible for obtaining the text of a WebElement in the skin classic.
     *
     * @return returns the text of the WebElement.
     */
    @Override
    public String getProductNameTxt() {
        wait.until(ExpectedConditions.visibilityOf(productNameTxt));
        return productNameTxt.getText();
    }

    /**
     * Method that is responsible for obtaining the text of a WebElement in the skin classic.
     *
     * @return returns the text of product code of the WebElement.
     */
    @Override
    public String getProductCodeTxt() {
        return productCodeTxt.getText();
    }

    /**
     * Method that is responsible for obtaining the text of a WebElement in the skin classic.
     *
     * @return returns the description of the WebElement.
     */
    @Override
    public String getProductDescriptionTxt() {
        return descriptionTxt.getText();
    }

    /**
     * Method that is responsible for obtaining the status of a WebElement in the skin classic.
     *
     * @return returns the status of the WebElement.
     */
    @Override
    public boolean getStatusChkBox() {
        return activeChkBox.isSelected();
    }

    /**
     * Method that is responsible for obtaining the selected option of a WebElement in the skin classic.
     *
     * @return returns the text of selected option of the WebElement.
     */
    @Override
    public String getProductFamilyCmbBox() {
        return productFamilyCmbBox.getText();
    }

    /**
     * Method responsible for clicking Edit button and redirecting to ProductsFormClassic.
     *
     * @return return a ProductsFormClassic page.
     */
    @Override
    public ProductsForm clickEditBtn() {
        if (driverTools.isElementDisplayed(exitBtn)) {
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickElement(editBtn);
        return new ProductsFormClassic();
    }

    /**
     * Method responsible for clicking the Delete button and redirecting to ProductsListPageClassic.
     *
     * @return return a ProductsListPageClassic page.
     */
    @Override
    public ProductsListPage clickDeleteBtn() {
        if (driverTools.isElementDisplayed(exitBtn)) {
            driverTools.clickElement(exitBtn);
        }
        wait.until(ExpectedConditions.invisibilityOf(exitBtn));
        if (driverTools.isElementDisplayed(adExitBtn)) {
            driverTools.clickElement(adExitBtn);
        }
        driver.switchTo().activeElement();
        driverTools.clickElement(deleteBtn);
        acceptAlertDialog();
        return new ProductsListPageClassic();
    }

    /**
     * Method responsible for verifying that a product can be eliminated.
     *
     * @return returns a boolean indicating if the product has been removed.
     */
    @Override
    public boolean verifyDeletedProduct(Product product) {
        return driverTools.isElementDisplayed((By.xpath(PRODUCT_LIST_INI + product.getProductName() + PRODUCT_LIST_END)));
    }
}
