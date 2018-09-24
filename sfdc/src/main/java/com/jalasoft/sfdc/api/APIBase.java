package com.jalasoft.sfdc.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.TOTAL_SIZE;

public abstract class APIBase {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    protected Map<String, Object> fieldsMap;
    protected String apiSObjectName;

    public APIBase() {
        fieldsMap = new HashMap<>();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected abstract Map<String, Object> covertEntityToMap();


    public boolean isSObjectRecordSaved() {
        response = apiManager.getQuery(apiSObjectName, fieldsMap);
        String totalSize = (response.jsonPath().get(TOTAL_SIZE)).toString();
        System.out.println("Query response get: " + response.asString());
        System.out.println("Total size: " + totalSize);

        if (totalSize != null) {
            return Integer.parseInt(totalSize) > 0;
        }
        return false;
    }

    protected abstract void setAPIObjectId();

    public void createSObjectRecord() {
        response = apiManager.post(apiSObjectName, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        setAPIObjectId();
    }

    protected abstract String getAPIObjectId();

    public void deleteSObjectRecord() {
        response = apiManager.delete(apiSObjectName, getAPIObjectId());
        System.out.println("Query response delete: " + response.asString());
    }
}
