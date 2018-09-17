/*
 * @(#)PriceBookListPage.java
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
 * Abstract class that contains the main page of Price Books.
 *
 * @author William Claros Revollo
 * @since 9/16/2018
 */
public abstract class PriceBookListPage extends BasePage {

    /**
     * Abstract method that redirects us to the Product form by pressing the New button.
     *
     * @return returns the Product form.
     */
    public abstract PriceBooksForm clickNewBtn();
}
