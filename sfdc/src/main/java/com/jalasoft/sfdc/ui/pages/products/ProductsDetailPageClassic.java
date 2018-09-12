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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class that has the product detail page of the classic skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsDetailPageClassic extends ProductsDetailPage {

    @FindBy(css = ".pageDescription")
    private WebElement productName;

    /**
     * Method that waits until the object of the page is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productName));
    }

    /**
     * Method that is responsible for obtaining the text of a WebElement.
     *
     * @return returns the text of the WebElement.
     */
    @Override
    public String getProductNameTxt() {
        wait.until(ExpectedConditions.visibilityOf(productName));
        return productName.getText();
    }
}