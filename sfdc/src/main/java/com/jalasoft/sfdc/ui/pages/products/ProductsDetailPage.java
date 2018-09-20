/*
 * @(#)ProductsDetailPage.java
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

import com.jalasoft.sfdc.ui.BasePage;

/**
 * Abstract class that has the product detail page.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public abstract class ProductsDetailPage extends BasePage {

    /**
     * Method that is responsible for obtaining the text of a WebElement.
     *
     * @return returns the text of the WebElement.
     */
    public abstract String getProductNameTxt();

    public abstract boolean getStatusChkBox();

}
