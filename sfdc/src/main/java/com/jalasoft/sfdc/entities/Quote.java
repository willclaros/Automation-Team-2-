/*
 * @(#)Quote.java
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

import java.util.List;

/**
 * Product class contains the Quote information.
 *
 * @author Team WYC
 * @since 9/25/2018
 */
public class Quote {

    private String quoteName;
    private List<QuoteLineItems> quoteLineItemsList;
    private String id;
    private String subTotal;
    private String opportunityId;

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    private String totalPrice;
    private String grandTotal;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /**
     * Method that obtains the information of the name of the Quote.
     *
     * @return returns the name of the Quote.
     */
    public String getQuoteName() {
        return quoteName;
    }

    /**
     * Method that setting the information of the name of the Quote.
     *
     * @param quoteName new input value so that it modifies the current value.
     */
    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
    }

    public String getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }
}
