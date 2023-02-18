package com.example.demo.core;

import com.example.demo.core.business.AccountBusinessManager;
import com.example.demo.core.config.DemoCoreConfigTest;
import com.example.demo.core.entity.Account;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.repository.AccountRepository;
import com.example.demo.core.repository.TransactionRepository;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(classes = DemoCoreConfigTest.class)
@ActiveProfiles({"core"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractTest {
    @Autowired
    protected AccountBusinessManager accountBusinessManager;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected AccountRepository accountRepository;
    @Autowired
    protected TransactionRepository transactionRepository;
    @Autowired
    protected AccountService accountService;

    protected List<Customer> customers;
    protected Account account1;

    @BeforeAll
    void setup() {
        System.out.println("Before All");
        populatesDB();
    }

    void populatesDB() {
//        customers = customerRepository.saveAll(List.of(buildCustomer("Jose", "Bart"), buildCustomer("Mel", "Foul")));
//        accountRepository.saveAll(List.of(buildAccount(0, )));
//        transactionRepository.saveAll(List.of(buildUser("Jose", "Bart"), buildUser("Mel", "Foul")));

//        account1 = accountService.createAccount(customers.get(0).getId(), 0L);
//        accountService.createAccount(users.get(0).getId(), 0L);
    }



//    Account buildAccount(Long balance, Long userId) {
//        var account = new Account();
//        account.setUserId(userId);
//        account.setBalance(balance);
//        return account;
//    }

}
