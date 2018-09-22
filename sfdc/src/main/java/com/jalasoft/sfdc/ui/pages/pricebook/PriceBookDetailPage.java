/*
 * @(#)PriceBookDetailPage.java
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

import com.jalasoft.sfdc.ui.BasePage;

/**
 * Abstract Class that has the Price Book detail page.
 *
 * @author William Claros Revollo
 * @since 9/16/2018
 */
public abstract class PriceBookDetailPage extends BasePage {

    /**
     * Abstract method that is responsible for obtaining the text a WebElement.
     *
     * @return returns the text of the WebElement.
     */
    public abstract String getPriceBookNameTxt();
    /**
     * Abstract method that is responsible for obtaining the text a WebElement.
     *
     * @return returns the text of the WebElement.
     */
    public abstract String getPriceBookDescriptionTxt();

}
