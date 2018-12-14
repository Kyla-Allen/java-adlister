package com.codeup.adlister;

public class Config {

    private String user = "ad_user";
    private String password = "kerokero";
    private String url = "jdbc:mysql://localhost:3306/adlister_db";

    public String getUser(){
        return user;
    }

    public String getPassword(){
        return password;
    }

    public String getUrl(){
        return url;
    }




}
