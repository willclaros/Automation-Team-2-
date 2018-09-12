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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class that has the form to create and update the information of a product of the light skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsFormLight extends ProductsForm {

    @FindBy(xpath = "//*[@aria-required='true']")
    private WebElement nameProductTxt;

    @FindBy(xpath = "(//span[text()='Save'])[2]")
    private WebElement saveBtn;

    /**
     * Method that performs the setting of the information of the fields of the form.
     *
     * @param name value of the field to be set.
     */
    @Override
    public void setFormProduct(String name) {
        driverTools.setInputField(nameProductTxt, name);
    }

    /**
     * Method that saves the form information by pressing the Save button.
     *
     * @return returns the page that contains the product detail.
     */
    @Override
    public ProductsDetailPage clickSaveBtn() {
        driverTools.clickElement(saveBtn);
        return new ProductsDetailPageLight();
    }

    /**
     * Method that waits until the object of the page is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.clickElement(saveBtn);
    }
}
