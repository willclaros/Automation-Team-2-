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

import com.jalasoft.sfdc.entities.Product;
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
     * @return returns the name of the WebElement.
     */
    public abstract String getProductNameTxt();

    /**
     * Method that is responsible for obtaining the text of a WebElement.
     *
     * @return returns the text of product code of the WebElement.
     */
    public abstract String getProductCodeTxt();

    /**
     * Method that is responsible for obtaining the text of a WebElement.
     *
     * @return returns the description of the WebElement.
     */
    public abstract String getProductDescriptionTxt();

    /**
     * Method that is responsible for obtaining the status of a WebElement.
     *
     * @return returns the status of the WebElement.
     */
    public abstract boolean getStatusChkBox();

    /**
     * Method that is responsible for obtaining the selected option of a WebElement.
     *
     * @return returns the text of selected option of the WebElement.
     */
    public abstract String getProductFamilyCmbBox();

    /**
     * Method responsible for clicking Edit button and redirecting to ProductsForm.
     *
     * @return return a ProductsForm page.
     */
    public abstract ProductsForm clickEditBtn();

    /**
     * Method responsible for clicking the Delete button and redirecting to ProductsListPage.
     *
     * @return return a ProductsListPage page.
     */
    public abstract ProductsListPage clickDeleteBtn();

    /**
     * Method responsible for verifying that a product can be eliminated.
     *
     * @return returns a boolean indicating if the product has been removed.
     */
    public abstract boolean verifyDeletedProduct(Product product);


    public abstract ProductAddStandardPrice gotoAddStandardPrice();


    public abstract ProductAddPriceBooks gotoAddPriceBook();
}
