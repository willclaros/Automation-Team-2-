/*
 * @(#)ProductsListPageClassic.java
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
 * Class that contains the main page of Product of the classic skin.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public class ProductsListPageClassic extends ProductsListPage {

    private static final String INIT_URL_CLASSIC = "https://na49.salesforce.com/";

    @FindBy(xpath = "//*[@value = ' New ']")
    private WebElement newBtn;

    @FindBy(xpath = "//*[@class='dialogClose']")
    private WebElement exitBtn;

    /**
     * Abstract class that redirects us to Product form by pressing the New button.
     *
     * @return returns the Product form.
     */
    @Override
    public ProductsForm clickNewBtn() {
        if (driverTools.isElementDisplayed(exitBtn)) {
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickElement(newBtn);
        return new ProductsFormClassic();
    }

    /**
     * Method that an Entity receives and through its ID navigate to a Product Detail Page in the skin classic.
     *
     * @param product an Entity of type Product.
     * @return returns a Product Detail Page Classic.
     */
    @Override
    public ProductsDetailPage goToTheDetailsPage(Product product) {
        driver.navigate().to(INIT_URL_CLASSIC + product.getId());
        driverTools.sleepMilliSeconds(6000);
        while (exitBtn.isDisplayed()){
            driverTools.clickElement(exitBtn);
        }
        wait.until(ExpectedConditions.invisibilityOf(exitBtn));
        return new ProductsDetailPageClassic();
    }

    /**
     * Method that waits until the page element is loaded..
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }
}
