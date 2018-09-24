package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Contact;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIContact {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Contact contact;
    private Contact contactAPI;
    protected Map<String, Object> fieldsMap;

    public APIContact(Contact contact) {
        this.contact = contact;
        fieldsMap = covertEntityToMap();
        contactAPI = new Contact();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(CONTACT_FIRST_NAME, contact.getFirstName());
        map.put(CONTACT_LAST_NAME, contact.getLastName());
        map.put(CONTACT_PHONE, contact.getHomePhone());
        map.put(CONTACT_TITLE, contact.getTitle());
        map.put(CONTACT_EMAIL, contact.getEmail());
//    map.put("NumberOfEmployees", account.getEmployees());
        return map;
    }

    public Contact getContactValuesByAPI() { //ToDo define what aee you going to return
        //response = APIManager.getInstance().get("/sobjects/Account/" + contact.getId() + "?fields=Name");
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(CONTACT).concat(SLASH).concat(contact.getId()));
        contactAPI.setLastName(response.jsonPath().get(CONTACT_LAST_NAME).toString());
        contactAPI.setEmail(response.jsonPath().get(CONTACT_EMAIL).toString());
        contactAPI.setTitle(response.jsonPath().get(CONTACT_TITLE).toString());
        System.out.println("response: " + response.asString());
        return contactAPI;
    }

    public void createContactByAPI() {
        response = apiManager.post(CONTACT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        contact.setId(response.jsonPath().get(ID).toString());
    }

    public void deleteContactByAPI() {
        response = apiManager.delete(CONTACT, contact.getId());
        System.out.println("Query response delete: " + response.asString());
    }

}
