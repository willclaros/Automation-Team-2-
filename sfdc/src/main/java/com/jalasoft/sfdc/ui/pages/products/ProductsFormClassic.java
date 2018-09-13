/*
 * @(#)ProductsFormClassic.java
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

import com.jalasoft.sfdc.entities.Products;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class that has the form to create and update the information of a product of the classic skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsFormClassic extends ProductsForm {

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement productNameTxt;

    @FindBy(xpath = "//input[@id='ProductCode']")
    private WebElement productCodeTxt;

    @FindBy(xpath = "//textarea[@id='Description']")
    private WebElement productDescripTxt;

    @FindBy(xpath = "//input[@name='IsActive']")
    private WebElement activeChkBox;

    @FindBy(xpath = "//*[@name = 'save']")
    private WebElement saveBtn;

    /**
     * Method that performs the setting of the information of the fields of the form.
     *
     * @param products value of the field to be set.
     */
    @Override
    public void setFormProduct(Products products) {
        driverTools.setInputField(productNameTxt, products.getProductName());
        driverTools.setInputField(productCodeTxt, products.getProductCode());
        driverTools.setInputField(productDescripTxt, products.getProductDescription());
        if (!products.isActive()) {
            driverTools.clickElement(activeChkBox);
        }
    }

    /**
     * Method that saves the form information by pressing the Save button.
     *
     * @return returns the page that contains the product detail.
     */
    @Override
    public ProductsDetailPage clickSaveBtn() {
        driverTools.clickElement(saveBtn);
        return new ProductsDetailPageClassic();
    }

    /**
     * Method that waits until the object of the page is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
    }
}