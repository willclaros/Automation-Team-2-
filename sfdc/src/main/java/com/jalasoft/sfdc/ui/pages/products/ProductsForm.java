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

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
     * @param product value of the field to be set.
     */
    public abstract ProductsDetailPage createProduct(Product product);

    /**
     * Method that edit the information of the fields of the form.
     *
     * @param product value of the field to be set.
     */
    public abstract ProductsDetailPage editProduct(Product product);
}
