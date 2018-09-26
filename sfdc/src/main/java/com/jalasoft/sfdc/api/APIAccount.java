package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Account;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;


public class APIAccount {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Account account;
    private Account accountApi;
    protected Map<String, Object> fieldsMap;

    public APIAccount(Account account) {
        this.account = account;
        accountApi = new Account();
        fieldsMap = covertEntityToMap();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("Name", account.getAccountName());
        map.put("TickerSymbol", account.getTicker());
        map.put("Phone", account.getPhone());
        map.put("Fax", account.getFax());
        map.put("AccountNumber", account.getAccountNumber());
        return map;
    }

    public Account getAccountValuesByAPI() { //ToDo define what aee you going to return
        response = APIManager.getInstance().get("/sobjects/Account/" + account.getId());
        accountApi.setAccountName(response.jsonPath().get(ACCOUNT_NAME).toString());
        accountApi.setAccountNumber(response.jsonPath().get(ACCOUNT_NUMBER).toString());
        accountApi.setPhone(response.jsonPath().get(ACCOUNT_PHONE).toString());
        accountApi.setFax(response.jsonPath().get(ACCOUNT_FAX).toString());
        accountApi.setTicker(response.jsonPath().get(ACCOUNT_TICKER).toString());
        return  accountApi;
    }

    public void createAccountByAPI() {
        response = apiManager.post(ACCOUNT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        account.setId(response.jsonPath().get(ID).toString());
    }

    public Response deleteAccountByAPI() {
        response = apiManager.delete(ACCOUNT, account.getId());
        System.out.println("Query response delete: " + response.asString());
        return  response;

    }

}
