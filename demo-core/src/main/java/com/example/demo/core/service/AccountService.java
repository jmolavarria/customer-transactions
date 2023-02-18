package com.example.demo.core.service;

import com.example.demo.core.entity.Account;
import com.example.demo.core.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    public Account createAccount(Long customerId, Long initialCredit) {
        var account = new Account();
        account.setCustomerId(customerId);
        account.setBalance(initialCredit);
        account = accountRepository.save(account);
     
        return account;
    }
    public List<Account> findByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }
}
