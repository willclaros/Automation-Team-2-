/*
 * @(#)PriceBooksForm.java
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

import com.jalasoft.sfdc.entities.PriceBook;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * Abstract class that has the form to create and update the information of a Price Books.
 *
 * @author William Claros Revollo
 * @since 9/16/2018
 */
public abstract class PriceBooksForm extends BasePage {

    /**
     * Abstract method that performs the setting of information of the fields of the form.
     *
     * @param priceBook value of the field to be set.
     */
    public abstract PriceBookDetailPage setFormPriceBook(PriceBook priceBook);
}
