package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.entities.Opportunity;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;
import static com.jalasoft.sfdc.constants.SFDCConstants.CONTACT;
import static com.jalasoft.sfdc.constants.SFDCConstants.ID;

public class APIOpportunities {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Opportunity opportunity;
    private Opportunity opportunityAPI;
    protected Map<String, Object> fieldsMap;

    /**
     * @param opportunity entity opportunity.
     */
    public APIOpportunities(Opportunity opportunity) {
        this.opportunity = opportunity;
        fieldsMap = covertEntityToMap();
        opportunityAPI = new Opportunity();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(OPPORTUNITY_NAME, opportunity.getNameOpportunity());
        map.put(OPPORTUNITY_STAGE_NAME, opportunity.getStage());
        map.put(OPPORTUNITY_CLOSE_DATE, opportunity.getCloseDate());
        return map;
    }

    /**
     * get a contact value ide.
     *
     * @return Contact entity.
     */
    public Opportunity getOpportunityValuesByAPI() {
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(CONTACT).concat(SLASH).concat(opportunity
                .getId()));
        opportunityAPI.setNameOpportunity(response.jsonPath().get(OPPORTUNITY_NAME).toString());
        opportunityAPI.setStage(response.jsonPath().get(OPPORTUNITY_STAGE_NAME).toString());
        opportunityAPI.setCloseDate(response.jsonPath().get(OPPORTUNITY_CLOSE_DATE).toString());
        System.out.println("response: " + response.asString());
        return opportunityAPI;
    }

    /**
     * create Opportunity api.
     *
     * @return response method.
     */
    public Response createOpportunityByAPI() {
        response = apiManager.post(CONTACT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        opportunity.setId(response.jsonPath().get(ID).toString());
        return response;
    }

    /**
     * delete a element Opportunity.
     *
     * @return response
     */
    public Response deleteOpportunityByAPI() {
        response = apiManager.delete(CONTACT, opportunity.getId());
        System.out.println("Query response delete: " + response.asString());
        System.out.println("Opportunity id: " + opportunity.getId());
        return response;
    }

}
