package com.example.demo.apps.controller;

import com.example.demo.core.business.AccountBusinessManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountManagementController {
    private final AccountBusinessManager accountBusinessManager;
    
    @GetMapping("/customer-info")
    AccountBusinessManager.CustomerInfoResponse customerInfo(@RequestParam String customerId) {
        return accountBusinessManager.getCustomerInfo(Long.valueOf(customerId));
    }
    
    @PostMapping("new-account")
    void newAccount(@RequestParam String customerId, @RequestParam String initialCredit) {
        accountBusinessManager.newAccount(Long.valueOf(customerId), Long.valueOf(initialCredit));
    }
}
