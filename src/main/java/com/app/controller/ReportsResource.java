package com.app.controller;

import com.app.model.BankAccount;
import com.app.repo.BankAccountRepository;
import com.app.service.ReportProcessor;

import javax.naming.InitialContext;
import java.util.List;
import java.util.concurrent.Future;


@Path("reports")
public class ReportsResource {

    BankAccountRepository repository;

    // Resource annotation
    @Resource(lookup="jndi name")
    ManagedExecutorService service;

    public ReportsResource() {
        // JNDI lookup
        // server provide default resources(concurrent resources, db connectors, JDBC, JMS, JNDI, java mail sessions, security, )
        //
//        InitialContext context=new InitialContext();
//         ManagedExecutorService service=(ManagedExecutorService) context.lookup("jndi name")


        // connection pooling from c3po library
        ComboPooledDataSource source=new ComboPooledDataSource();
        source.setJdbcUrl("");
        source.setDriverClass("");
        // user and pass

    }

    @GET
    String generateReports(){
        List<BankAccount> accounts=repository.getAllBankAccounts();
        for(BankAccount account:accounts){
            Future future = service.submit(new ReportProcessor(account, repository));

        }
        return "success"
    }
}
