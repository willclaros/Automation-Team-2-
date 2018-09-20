/*
 * @(#)ProductsDetailPageLight.java
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

/**
 * Class that has the productNameTxt detail page of the light skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsDetailPageLight extends ProductsDetailPage {

    @FindBy(xpath = "//span[contains(text(),'Details')]")
    private WebElement detailBtn;

    @FindBy(xpath = "//span[text()='Product Name']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement productNameTxt;

    @FindBy(xpath = "//span[text()='Product Code']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement productCodeTxt;

    @FindBy(xpath = "//span[text()='Product Description']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement descriptionTxt;

    @FindBy(css = ".uiOutputCheckbox .unchecked")
    private WebElement activeChkBox;

    @FindBy(xpath = "//span[text()='Product Family']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement productFamilyCmbBox;

    @FindBy(css = ".sldsButtonHeightFix")
    private WebElement actionsBtn;

    @FindBy(css = "a[title='Edit']")
    private WebElement editBtn;

    @FindBy(css = "a[title='Delete']")
    private WebElement deleteBtn;

    @FindBy(css = ".modal-body .detail")
    private WebElement messageDelete;

    @FindBy(css = ".forceActionButton[title='Delete']")
    private WebElement messageDeleteBtn;

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productNameTxt));
    }

    /**
     * Method that is responsible for obtaining the text of a WebElement in the skin light.
     *
     * @return returns the text of the WebElement.
     */
    @Override
    public String getProductNameTxt() {
        return productNameTxt.getText();
    }

    /**
     * Method that is responsible for obtaining text of a WebElement in the skin light.
     *
     * @return returns the text of product code of the WebElement.
     */
    @Override
    public String getProductCodeTxt() {
        return productCodeTxt.getText();
    }

    /**
     * Method that is responsible for obtaining the text of a WebElement in the skin light.
     *
     * @return returns the description of the WebElement.
     */
    @Override
    public String getProductDescriptionTxt() {
        return descriptionTxt.getText();
    }

    /**
     * Method that is responsible for obtaining the status of a WebElement in the skin light.
     *
     * @return returns the status of the WebElement.
     */
    @Override
    public boolean getStatusChkBox() {
        return activeChkBox.isSelected();
    }

    /**
     * Method that is responsible for obtaining the selected option of a WebElement in the skin light.
     *
     * @return returns the text of selected option of the WebElement.
     */
    @Override
    public String getProductFamilyCmbBox() {
        return productFamilyCmbBox.getText();
    }

    /**
     * Method responsible for clicking the Edit button and redirecting to ProductsFormLight.
     *
     * @return return a ProductsFormLight page.
     */
    @Override
    public ProductsForm clickEditBtn() {
        driverTools.clickElement(actionsBtn);
        driverTools.clickElement(editBtn);
        return new ProductsFormLight();
    }

    /**
     * Method responsible for clicking the Delete button and redirecting to ProductsListPageLight.
     *
     * @return return a ProductsListPageLight page.
     */
    @Override
    public ProductsListPage clickDeleteBtn() {
        driverTools.clickElement(actionsBtn);
        driverTools.clickElement(deleteBtn);
        driverTools.clickElement(messageDeleteBtn);
        return new ProductsListPageLight();
    }

    /**
     * Method responsible for verifying that a product can be eliminated.
     *
     * @return returns a boolean indicating if the product has been removed.
     */
    @Override
    public boolean verifyDeletedProduct(Product product) {
        return driverTools.isElementDisplayed((By.xpath("//a[text()= '"+product.getProductName()+"']")));
    }
}
