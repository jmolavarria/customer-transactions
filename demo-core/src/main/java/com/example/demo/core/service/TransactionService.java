package com.example.demo.core.service;

import com.example.demo.core.business.AccountBusinessManager;
import com.example.demo.core.entity.Transaction;
import com.example.demo.core.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public void createTransaction(Long accountId, Long amount) {
        var transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transactionRepository.save(transaction);
    }

    public List<Transaction> findByAccountId(Long id) {
        return transactionRepository.findALLByAccountId(id);
    }
}
