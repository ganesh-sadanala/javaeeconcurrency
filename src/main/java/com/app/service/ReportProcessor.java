package com.app.service;

import com.app.model.BankAccount;
import com.app.model.BankAccountTransaction;
import com.app.repo.BankAccountRepository;

import java.io.*;
import java.util.List;
import java.util.concurrent.Callable;

public class ReportProcessor implements Callable<Boolean> {
    BankAccount account;
    BankAccountRepository repository;

    @Override
    public Boolean call() throws Exception {
        // get transactions associated for the account
        List<BankAccountTransaction> transactions=repository.getTransactionsForAccount(account);
        // write those transactions to file
        File file=new File("path");
        for(BankAccountTransaction xaction: transactions){
            try{
                BufferedWriter writer=new BufferedWriter(new FileWriter(file));
                // write
            }catch (IOException e){}
        }
        return true;
    }
}
