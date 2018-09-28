/*
 * @(#)Opportunity.java
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
 * Product class contains the Opportunity information.
 *
 * @author William Claros Revollo
 * @since 9/25/2018
 */
public class Opportunity {

    private String nameOpportunity = "";
    private String closeDate = "";
    private String stage = "";
    private String id;

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Method that obtains the information of name of the Opportunity.
     *
     * @return returns the name of the Opportunity.
     */
    public String getNameOpportunity() {
        return nameOpportunity;
    }

    /**
     * Method that setting the information of the name of the Opportunity.
     *
     * @param nameOpportunity new input value so that it modifies the current value.
     */
    public void setNameOpportunity(String nameOpportunity) {
        this.nameOpportunity = nameOpportunity;
    }

    /**
     * Method that obtains the information of the close date of the Opportunity.
     *
     * @return returns the close date of the Opportunity.
     */
    public String getCloseDate() {
        return closeDate;
    }

    /**
     * Method that setting the information of the close date of the Opportunity.
     *
     * @param closeDate new input value so that it modifies the current value.
     */
    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * Method that obtains the information of the stage of the Opportunity.
     *
     * @return returns the stage of the Opportunity.
     */
    public String getStage() {
        return stage;
    }

    /**
     * Method that setting the information of the stage of the Opportunity.
     *
     * @param stage new input value so that it modifies the current value.
     */
    public void setStage(String stage) {
        this.stage = stage;
    }
}
