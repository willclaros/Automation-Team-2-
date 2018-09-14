/*
 * @(#)ProductsFormLight.java
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

/**
 * Class that has the form to create and update the information of a product of the light skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsFormLight extends ProductsForm {

    @FindBy(xpath = "//*[@aria-required='true']")
    private WebElement productNameTxtBox;

    @FindBy(xpath = "//span[text()='Product Code']/parent::label/following-sibling::input")
    private WebElement productCodeTxtBox;

    @FindBy(css = ".textarea")
    private WebElement descriptionTxtBox;

    @FindBy(css = ".uiInput--checkbox input")
    private WebElement activeChkBox;

    @FindBy(xpath = "//button[@title ='Save']")
    private WebElement saveBtn;

    @FindBy(css = ".select")
    private WebElement productFamilyLabel;

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
    }

    /**
     * Method that performs the setting of the information of the fields of the form.
     *
     * @param product value of the field to be set.
     */
    @Override
    public ProductsDetailPage createProduct(Product product) {
        driverTools.setInputField(productNameTxtBox, product.getProductName());
        driverTools.setInputField(productCodeTxtBox, product.getProductCode());
        driverTools.setInputField(descriptionTxtBox, product.getProductDescription());
        if (product.getStatusActive().equalsIgnoreCase("false") || product.getStatusActive().isEmpty()) {
            driverTools.clearChkBox(activeChkBox);
        } else {
            driverTools.selectChkBox(activeChkBox);
        }
        chooseProductFamilyLightCmbBox(product.getProductFamily());
        driverTools.clickElement(saveBtn);
        return new ProductsDetailPageLight();
    }

    /**
     * Method that edit the information of the fields of the form in the skin light.
     *
     * @param product value of the field to be set.
     */
    @Override
    public ProductsDetailPage editProduct(Product product) {
        driverTools.clickElement(productNameTxtBox);
        driverTools.setInputField(productNameTxtBox, product.getProductName());

        driverTools.clickElement(productCodeTxtBox);
        driverTools.setInputField(productCodeTxtBox, product.getProductCode());

        driverTools.clickElement(descriptionTxtBox);
        driverTools.setInputField(descriptionTxtBox, product.getProductDescription());

        driverTools.clickElement(saveBtn);
        wait.until(ExpectedConditions.invisibilityOf(saveBtn));
        return new ProductsDetailPageLight();
    }

    /**
     * Method that selects an element of the combo box and has as input a string.
     *
     * @param productFamily is a string that represents the option of the combo box that is required to select.
     */
    public ProductsForm chooseProductFamilyLightCmbBox(final String productFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(productFamilyLabel));
        driverTools.clickElement(productFamilyLabel);
        if (!productFamily.isEmpty()) {
            driverTools.clickElement(driver.findElement(By.xpath("//a[text()='" + productFamily + "']")));
        }
        return this;
    }
}
