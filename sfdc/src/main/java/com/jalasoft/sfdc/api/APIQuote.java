package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Quote;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIQuote {

    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Quote quote;
    private Quote quoteAPI;
    protected Map<String, Object> fieldsMap;

    /**
     * Constructor of the APIProduct class.
     *
     * @param quote is an entity of type Product.
     */
    public APIQuote(Quote quote) {
        this.quote = quote;
        fieldsMap = covertEntityToMap();
        quoteAPI = new Quote();
    }

    /**
     * Method converts the Entities to Map.
     *
     * @return a map with all values of the Entities.
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(NAME, quote.getQuoteName());
        map.put(SUBTOTAL_QUOTE,quote.getSubTotal());
        map.put(GRAND_TOTAL_QUOTE, quote.getGrandTotal());
        map.put(OPPORTUNITY_ID_QUOTE, quote.getOpportunityId());
        return map;
    }

    /**
     * Method that retrieves the values of an API Product and sets it to the Product Entity.
     *
     * @return productAPI returns an Entity of type Product.
     */
    public Quote getQuotesValuesByAPI() {
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(QUOTE).concat(SLASH).concat(quote.getId()));
        quoteAPI.setQuoteName(response.jsonPath().get(NAME).toString());
        quoteAPI.setSubTotal(response.jsonPath().get(SUBTOTAL_QUOTE).toString());
        quoteAPI.setGrandTotal(response.jsonPath().get(GRAND_TOTAL_QUOTE).toString());
        quoteAPI.setOpportunityId(response.jsonPath().get(OPPORTUNITY_ID_QUOTE).toString());
        System.out.println("response: " + response.asString()+"159159159159159159159");
        return quoteAPI;
    }

    /**
     * Method to create a Product through API.
     *
     * @return response return.
     */
    public Response createQuoteByAPI() {
        response = apiManager.post(QUOTE, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        quote.setId(response.jsonPath().get(ID).toString());
        return response;
    }

    /**
     * Method to delete a Product through API.
     *
     * @return response return.
     */
    public Response deleteQuoteByAPI() {
        response = apiManager.delete(QUOTE, quote.getId());
        System.out.println("Query response delete: " + response.asString());
        return response;
    }
}
