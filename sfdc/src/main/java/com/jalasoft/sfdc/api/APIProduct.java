/*
 * @(#)APIProduct.java
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
package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Product;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

/**
 * APIProduct class contains the Product information.
 *
 * @author William Claros Revollo
 * @since 9/24/2018
 */
public class APIProduct {

    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Product product;
    private Product productAPI;
    protected Map<String, Object> fieldsMap;

    /**
     * Constructor of the APIProduct class.
     *
     * @param product is an entity of type Product.
     */
    public APIProduct(Product product) {
        this.product = product;
        fieldsMap = covertEntityToMap();
        productAPI = new Product();
    }

    /**
     * Method converts the Entities to Map.
     *
     * @return a map with all values of the Entities.
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(NAME, product.getProductName());
        map.put(PRODUCT_CODE, product.getProductCode());
        map.put(DESCRIPTION, product.getProductDescription());
        //map.put(IS_ACTIVE, product.getStatusActive());
        return map;
    }

    /**
     * Method that retrieves the values of an API Product and sets it to the Product Entity.
     *
     * @return productAPI returns an Entity of type Product.
     */
    public Product getProductsValuesByAPI() {
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(PRODUCTS).concat(SLASH).concat(product.getId()));
        productAPI.setProductName(response.jsonPath().get(NAME).toString());
        productAPI.setProductCode(response.jsonPath().get(PRODUCT_CODE).toString());
        productAPI.setProductDescription(response.jsonPath().get(DESCRIPTION).toString());
        //productAPI.setStatusActive(response.jsonPath().get(IS_ACTIVE).toString());
        System.out.println("response: " + response.asString());
        return productAPI;
    }

    /**
     * Method to create a Product through API.
     *
     * @return response return.
     */
    public Response createProductByAPI() {
        response = apiManager.post(PRODUCTS, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        product.setId(response.jsonPath().get(ID).toString());
        return response;
    }

    /**
     * Method to delete a Product through API.
     *
     * @return response return.
     */
    public Response deleteProductByAPI() {
        response = apiManager.delete(PRODUCTS, product.getId());
        System.out.println("Query response delete: " + response.asString());
        return response;
    }
}
