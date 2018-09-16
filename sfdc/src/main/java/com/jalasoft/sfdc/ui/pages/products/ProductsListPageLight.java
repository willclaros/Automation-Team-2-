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

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class that contains the main page of Product of the light skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsListPageLight extends ProductsListPage {

    private static final String INIT_URL_LIGHT = "https://na49.lightning.force.com/lightning/r/Product2/";
    private static final String END_URL = "/view";

    @FindBy(css = ".forceActionLink[title='New']")
    private WebElement newBtn;

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    /**
     * Method that redirects us to Product form by pressing the New button.
     *
     * @return returns the Product form.
     */
    @Override
    public ProductsForm clickNewBtn() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
        driverTools.clickElement(newBtn);
        return new ProductsFormLight();
    }

    /**
     * Method that an Entity receives and through its ID navigate to a Product Detail Page in the skin light.
     *
     * @param product an Entity of type Product.
     * @return returns a Product Detail Page Light.
     */
    @Override
    public ProductsDetailPage goToTheDetailsPage(Product product) {
        driver.navigate().to(INIT_URL_LIGHT + product.getId() + END_URL);
        return new ProductsDetailPageLight();
    }
}
