package com.example.demo.core.sample;

import com.example.demo.core.entity.Account;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Transaction;

import java.util.List;

/**
 * Sample data only
 */
public class SampleDataUtil {
    public static List<Customer> sampleCustomers(){
        return List.of(
                buildCustomer("Jose", "Bart", 1l), 
                buildCustomer("Mel", "Foul", 2L),
                buildCustomer("Teo", "Gibs", 3L)
        );
    }
    
    public static Account sampleAccount(){
        return new Account(1L, 50L);
    }
    
    public static List<Transaction> sampleTransactions() {
        return List.of(buidTransaction(100L, 1L), buidTransaction(-50L, 1L));
    }

    static Customer buildCustomer(String name, String surname, Long id) {
        var customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setSurname(surname);
        return customer;
    }

    static Transaction buidTransaction(Long amount, Long accountId) {
        var transaction  =  new Transaction();
        transaction.setAmount(amount);
        transaction.setAccountId(accountId);

        return transaction;
    }
}
