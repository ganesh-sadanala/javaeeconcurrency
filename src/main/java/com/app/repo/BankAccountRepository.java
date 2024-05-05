package com.app.repo;

import com.app.model.BankAccount;
import com.app.model.BankAccountTransaction;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountRepository {
    DataSource dataSource;

    public BankAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<BankAccount> getAllBankAccounts(){
        Connection connection= null;
        List<BankAccount> accounts = new ArrayList<>();
        try {
            connection = dataSource.getConnection();

            BankAccount account = null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from bank_account");

            while (resultSet.next()) {
                // add to accounts
            }
        }catch (SQLException e){

        }
        return accounts;
    }

    public List<BankAccountTransaction> getTransactionsForAccount(BankAccount account){
        Connection connection= null;
        List<BankAccountTransaction> transactions = new ArrayList<>();
        try {
            connection = dataSource.getConnection();

            PreparedStatement statement=connection.prepareStatement("select * from bank_account_transaction where account_number=?");
            statement.setString(1, "...");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // add to transactions
            }
        }catch (SQLException e){

        }
    }
}
