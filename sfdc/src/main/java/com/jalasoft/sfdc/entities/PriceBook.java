/*
 * @(#)PriceBook.java
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

/**
 * PriceBook class contains the price books information.
 *
 * @author William Claros Revollo
 * @since 9/16/2018
 */
public class PriceBook {

    private String priceBookName = "";
    private String description = "";
    private String status = "";

    /**
     * Method that obtains the information of the name of the Price Books.
     *
     * @return returns the name of the product.
     */
    public String getPriceBookName() {
        return priceBookName;
    }

    /**
     * Method that setting the information of the name of the Price Books.
     *
     * @param priceBookName new input value so that it modifies the current value.
     */
    public void setPriceBookName(String priceBookName) {
        this.priceBookName = priceBookName;
    }

    /**
     * Method that obtains the information of the description of the Price Books.
     *
     * @return returns the code of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method that setting the information of the description of the Price Books.
     *
     * @param description new input value so that it modifies the current value.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method that obtains the information of the state of the Price Books.
     *
     * @return returns the state of the Price Books.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Method that setting the information of the state of the Price Books.
     *
     * @param status new input value so that it modifies the current value.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
