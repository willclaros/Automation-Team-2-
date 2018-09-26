package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.AutomationSFDC;
import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.config.UsersConfigReader;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        System.setProperty("server", "DevOrg01");
        System.setProperty("skin", "Light");
        String usersConfigFileName =
                System.getProperty("user.dir") + File.separator + "sfdc/config" + File.separator + "SFDCUsers.json";
        String serversConfigFileName =
                System.getProperty("user.dir") + File.separator + "sfdc/config" + File.separator + "SFDCServers.json";

        UsersConfigReader.getInstance().initialize(usersConfigFileName);
        ServersConfigReader.getInstance().initialize(serversConfigFileName);

        Response responseAccount = APIManager.getInstance().get("/sobjects/Account/0010b00002C6QNtAAN");
        System.out.println(responseAccount.asString());

        Response responseQuote = APIManager.getInstance().get("/sobjects/Quote/0Q00b000001Ly5GCAS");
        System.out.println(responseQuote.asString());

//        Map<String, Object> jsonData = new HashMap<>();
//        jsonData.put("Name","Acccount test123");
//
//        Response responseAccount2 = APIManager.getInstance().post("/sobjects/Account/",jsonData);
//        System.out.println(responseAccount2.asString());

    }
}