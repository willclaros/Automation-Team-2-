/*
 * @(#)ProductsForm.java
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

import com.jalasoft.sfdc.entities.Products;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * Abstract class that has the form to create and update the information of a product.
 *
 * @author William Claros Revollo
 * @since 9/11/2018
 */
public abstract class ProductsForm extends BasePage {

    /**
     * Method that performs the setting of the information of the fields of the form.
     *
     * @param products value of the field to be set.
     */
    public abstract void setFormProduct(Products products);

    /**
     * Method that saves the form information by pressing the Save button.
     *
     * @return returns the page that contains the product detail.
     */
    public abstract ProductsDetailPage clickSaveBtn();
}
