/*
 * @(#)ProductsListPageLight.java
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
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class that contains the main page of Products of the light skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsListPageLight extends ProductsListPage {

    @FindBy(css = ".forceActionLink")
    private WebElement newBtn;

    /**
     * Abstract class that redirects us to the Products form by pressing the New button.
     *
     * @return returns the Products form.
     */
    @Override
    public ProductsForm clickNewBtn() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
        driverTools.clickElement(newBtn);
        return new ProductsFormLight();
    }

    /**
     * Method that waits until the object of the page is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }
}