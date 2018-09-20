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

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
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
    private WebElement productNameTxtBox;

    @FindBy(xpath = "//input[@id='ProductCode']")
    private WebElement productCodeTxtBox;

    @FindBy(xpath = "//textarea[@id='Description']")
    private WebElement descriptionTxtBox;

    @FindBy(xpath = "//input[@name='IsActive']")
    private WebElement activeChkBox;

    @FindBy(css = ".btn[name = 'save']")
    private WebElement saveBtn;

    @FindBy(css = "select[id='Family']")
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
        if(product.getStatusActive().equalsIgnoreCase("false") || product.getStatusActive().isEmpty()){
            driverTools.clearChkBox(activeChkBox);
        }else{
            driverTools.selectChkBox(activeChkBox);
        }
        chooseProductFamilyClassicCmbBox(product.getProductFamily());

        driverTools.clickElement(saveBtn);
        return new ProductsDetailPageClassic();
    }

    /**
     * Method that edit the information of fields of the form in the skin classic.
     *
     * @param product value of the field to be set.
     */
    @Override
    public ProductsDetailPage editProduct(Product product) {
        driverTools.setInputField(productNameTxtBox, product.getProductName());
        driverTools.setInputField(productCodeTxtBox, product.getProductCode());
        driverTools.setInputField(descriptionTxtBox, product.getProductDescription());
        driverTools.clickElement(saveBtn);
        return new ProductsDetailPageClassic();
    }

    /**
     * Method that selects an element of the combo box and has as input a string.
     *
     * @param productFamily is a string that represents the option of the combo box that is required to select.
     */
    public ProductsForm chooseProductFamilyClassicCmbBox(final String productFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(productFamilyLabel));
        driverTools.clickElement(productFamilyLabel);
        if (!productFamily.isEmpty()) {
            driverTools.clickElement(driver.findElement(By.cssSelector("[value=" + productFamily + "]")));
        }
        return this;
    }
}
