package br.com.restassuredapitesting.tests.auth.resquests.payloads;

import org.json.JSONObject;

public class AuthPayloads {

    public JSONObject jsonAuthLogin(){
        JSONObject payLoadLogin = new JSONObject();

        payLoadLogin.put("username","admin");
        payLoadLogin.put("password","password123");

        return payLoadLogin;
    }
}
