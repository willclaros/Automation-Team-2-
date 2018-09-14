/*
 * @(#)Product.java
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
package com.jalasoft.sfdc.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Product class contains the product information.
 *
 * @author William Claros Revollo
 * @since 9/12/2018
 */
public class Product {

    private String productName = "";
    private String productCode = "";
    private String productDescription = "";
    private String active = "";
    private String productFamily = "";

    /**
     * Method that obtains the information of the name of the Product.
     *
     * @return returns the name of the product.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Method that setting the information of the name of the Product.
     *
     * @param productName new input value so that it modifies the current value.
     */
    public void setProductName(String productName) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.productName = productName.concat(timeStamp);
    }

    /**
     * Method that obtains the information of the code of the Product.
     *
     * @return returns the code of the product.
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Method that setting the information of the code of the Product.
     *
     * @param productCode new input value so that it modifies the current value.
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * Method that obtains the information of the description of the Product.
     *
     * @return returns the description of the product.
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Method that setting the information of the description of the Product.
     *
     * @param productDescription new input value so that it modifies the current value.
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Method that obtains the information of the state of the Product.
     *
     * @return returns the state of the product.
     */
    public String getStatusActive() {
        return active;
    }

    /**
     * Method that setting the information of the state of the Product.
     *
     * @param active new input value so that it modifies the current value.
     */
    public void setStatusActive(String active) {
        this.active = active;
    }

    /**
     * Method that obtains the information of the option the combo box of the Product.
     *
     * @return returns the a option of the combo box of the product.
     */
    public String getProductFamily() {
        return productFamily;
    }

    /**
     * Method that setting the information of the option of the combo box of the Product.
     *
     * @param productFamily new input value so that it modifies the current value.
     */
    public void setProductFamily(String productFamily) {
        this.productFamily = productFamily;
    }
}
