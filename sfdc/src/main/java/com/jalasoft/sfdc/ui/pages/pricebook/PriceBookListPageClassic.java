/*
 * @(#)PriceBookListPageClassic.java
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
package com.jalasoft.sfdc.ui.pages.pricebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class that contains the main page of Price Books of the classic skin.
 *
 * @author William Claros Revollo
 * @since 9/16/2018
 */
public class PriceBookListPageClassic extends PriceBookListPage {

    @FindBy(css = ".btn[title*='New']")
    private WebElement newBtn;

    @FindBy(xpath = "//*[@class='dialogClose']")
    private WebElement exitBtn;

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    /**
     * Method that redirects us to the Price Book form by pressing the New button.
     *
     * @return returns the Price Book Classic form.
     */
    @Override
    public PriceBooksForm clickNewBtn() {
        if (driverTools.isElementDisplayed(exitBtn)) {
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickElement(newBtn);
        return new PriceBooksFormClassic();
    }
}
