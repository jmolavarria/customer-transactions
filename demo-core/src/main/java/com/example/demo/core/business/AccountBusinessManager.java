package com.example.demo.core.business;

import com.example.demo.core.entity.Account;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.service.AccountService;
import com.example.demo.core.service.CustomerService;
import com.example.demo.core.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AccountBusinessManager {
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final CustomerService customerService;

    public Account newAccount(Long customerId, Long initialCredit) {
        var account  = accountService.createAccount(customerId,initialCredit);

        if (initialCredit != 0L) {
            transactionService.createTransaction(account.getId(), initialCredit);
        }
        return account;
    }

    public CustomerInfoResponse getCustomerInfo(Long id) {
        return customerService.find(id)
                .map(this::buildCustomerInfoRepose).orElse(null);
    }
    
    private CustomerInfoResponse buildCustomerInfoRepose(Customer c) {
        return new CustomerInfoResponse(c.getName(), c.getSurname(),
                accountService.findByCustomerId(c.getId()).stream()
                        .map(this::buildAccountInfoResponse)
                        .toList()
        );
    }

    private AccountInfoResponse buildAccountInfoResponse(Account a) {
        return new AccountInfoResponse(a.getBalance(), 
                transactionService.findByAccountId(a.getId()).stream()
                        .map(t -> new TransactionInfoResponse(t.getAmount()))
                        .toList()
        );
    }

    public record CustomerInfoResponse(
            String name,
            String surname,
            List<AccountInfoResponse> accounts
    ){}
    
    public record AccountInfoResponse(Long balance, List<TransactionInfoResponse> transactions){}
    public record TransactionInfoResponse(Long amount){}
}
