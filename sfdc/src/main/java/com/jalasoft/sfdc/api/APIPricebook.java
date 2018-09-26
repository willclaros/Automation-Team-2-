package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.PriceBook;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIPricebook {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final PriceBook priceBook;
    private PriceBook PricebookAPI;
    protected Map<String, Object> fieldsMap;

    /**
     * @param priceBook entity priceBook.
     */
    public APIPricebook(PriceBook priceBook) {
        this.priceBook = priceBook;
        fieldsMap = covertEntityToMap();
        PricebookAPI = new PriceBook();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(NAME_PRICEBOOK, priceBook.getPriceBookName());
        map.put(DESCRIPTION_PRICEBOOK, priceBook.getDescription());
        map.put(IS_ACTIVE_PRICEBOOK, priceBook.getStatus());
        map.put(IS_STANDARD_PRICEBOOK, priceBook.isStandard());
        return map;
    }

    /**
     * get a contact value ide.
     *
     * @return Contact entity.
     */
    public PriceBook getContactValuesByAPI() { //ToDo define what aee you going to return
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(PRICEBOOK).concat(SLASH).concat(priceBook.getId()));
        PricebookAPI.setPriceBookName(response.jsonPath().get(NAME_PRICEBOOK).toString());
        PricebookAPI.setDescription(response.jsonPath().get(DESCRIPTION_PRICEBOOK).toString());
        PricebookAPI.setStatus(response.jsonPath().get(IS_ACTIVE_PRICEBOOK).toString());
        PricebookAPI.setStandard(response.jsonPath().get(IS_STANDARD_PRICEBOOK).toString());
        System.out.println("response: " + response.asString());
        return PricebookAPI;
    }

    /**
     * create Pricebook api.
     *
     * @return response method.
     */
    public Response createPricebookByAPI() {
        response = apiManager.post(PRICEBOOK, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        priceBook.setId(response.jsonPath().get(ID).toString());
        return response;
    }

    /**
     * delete a element pricebook.
     *
     * @return response
     */
    public Response deletePricebookByAPI() {
        response = apiManager.delete(PRICEBOOK, priceBook.getId());
        System.out.println("Query response delete: " + response.asString());
        //System.out.println("contact id: " + priceBook.getId());
        return response;
    }
}
