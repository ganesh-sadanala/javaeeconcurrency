package com.app.controller;

import com.app.model.BankAccount;
import com.app.repo.BankAccountRepository;
import com.app.service.ReportProcessor;
import com.app.service.UrlHealthProcessor;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Path("urlCheck")
public class UrlHealthCheckResource {

    BankAccountRepository repository;

    // Resource annotation
    @Resource(lookup="jndi name")
    ManagedScheduledExecutorService service;

    @GET
    String checkHealthOfApp(){
        Future<Boolean> future = service.submit(new UrlHealthProcessor(), 3, TimeUnit.SECONDS);
        return "success";
    }
}


