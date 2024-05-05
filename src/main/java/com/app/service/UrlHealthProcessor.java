package com.app.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.concurrent.Callable;

public class UrlHealthProcessor implements Callable<Boolean> {
    @Override
    public Boolean call() {
        URL url=new URL("");
        HttpURLConnection connection=url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode=connection.getResponseCode();
        if(responseCode==200) return true;
        return false;
    }
}
