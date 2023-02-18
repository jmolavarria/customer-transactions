package com.example.demo.apps.controller;

import com.example.demo.apps.AbstractIntegrationTest;
import com.example.demo.core.sample.SampleDataUtil;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserAccountControllerTest extends AbstractIntegrationTest {

    @PostConstruct
    void setup() {
        customerRepository.saveAll(SampleDataUtil.sampleCustomers());
        accountRepository.save(SampleDataUtil.sampleAccount());
        transactionRepository.saveAll(SampleDataUtil.sampleTransactions());
    }
    
    @SneakyThrows
    @Test
    void getCustomerInfo(){
        var customerId = 1L;
        mockMvc.perform(get("/customer-info").param("customerId", String.valueOf(customerId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Jose")))
                .andExpect(jsonPath("$.accounts",hasSize(1)))
                .andExpect(jsonPath("$.accounts[0].balance",equalTo(50)))
                .andExpect(jsonPath("$.accounts[0].transactions",hasSize(2)));
    }

    @SneakyThrows
    @Test
    void givenCreditZero_newAccountIsCreated() {
        var customerId = 2L;
        mockMvc.perform(post("/new-account").param("customerId", String.valueOf(customerId)).param("initialCredit", "0"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/customer-info").param("customerId", String.valueOf(customerId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Mel")))
                .andExpect(jsonPath("$.accounts", hasSize(1)))
                .andExpect(jsonPath("$.accounts[0].balance", equalTo(0)))
                .andExpect(jsonPath("$.accounts[0].transactions", hasSize(0)));
    }

    @SneakyThrows
    @Test
    void givenCreditDifferentThanZero_newAccountIsCreated(){
        var customerId = 3L;
        mockMvc.perform(post("/new-account").param("customerId", String.valueOf(customerId)).param("initialCredit", "200"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/customer-info").param("customerId", String.valueOf(customerId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Teo")))
                .andExpect(jsonPath("$.accounts",hasSize(1)))
                .andExpect(jsonPath("$.accounts[0].balance",equalTo(200)))
                .andExpect(jsonPath("$.accounts[0].transactions",hasSize(1)));
    }
}
