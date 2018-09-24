package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Product;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIProduct {

    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Product product;
    private Product productAPI;
    protected Map<String, Object> fieldsMap;

    public APIProduct(Product product) {
        this.product = product;
        fieldsMap = covertEntityToMap();
        productAPI = new Product();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(NAME, product.getProductName());
        map.put(PRODUCT_CODE, product.getProductCode());
        map.put(DESCRIPTION, product.getProductDescription());
        //map.put(IS_ACTIVE, product.getStatusActive());
        return map;
    }

    public Product getProductsValuesByAPI() {
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(PRODUCTS).concat(SLASH).concat(product.getId()));
        productAPI.setProductName(response.jsonPath().get(NAME.toString()));
        productAPI.setProductCode(response.jsonPath().get(PRODUCT_CODE).toString());
        productAPI.setProductDescription(response.jsonPath().get(DESCRIPTION).toString());
        //productAPI.setStatusActive(response.jsonPath().get(IS_ACTIVE).toString());
        System.out.println("response: " + response.asString());
        return productAPI;
    }

    public void createProductByAPI() {
        response = apiManager.post(PRODUCTS, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        product.setId(response.jsonPath().get(ID).toString());
    }

    public void deleteContactByAPI() {
        response = apiManager.delete(PRODUCTS, product.getId());
        System.out.println("Query response delete: " + response.asString());
    }
}
