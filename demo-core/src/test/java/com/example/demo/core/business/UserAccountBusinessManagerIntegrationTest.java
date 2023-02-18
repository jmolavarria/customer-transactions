package com.example.demo.core.business;

import com.example.demo.core.AbstractTest;
import com.example.demo.core.sample.SampleDataUtil;
import jakarta.annotation.PostConstruct;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserAccountBusinessManagerIntegrationTest extends AbstractTest {
    @PostConstruct
    void setup() {
        customerRepository.saveAll(SampleDataUtil.sampleCustomers());
        accountRepository.save(SampleDataUtil.sampleAccount());
        transactionRepository.saveAll(SampleDataUtil.sampleTransactions());
    }

    @Test
    void customerInfo_Success() {
        var customer = this.accountBusinessManager.getCustomerInfo(1L);
        Assertions.assertThat(customer)
                .extracting(AccountBusinessManager.CustomerInfoResponse::name).isEqualTo("Jose");
        Assertions.assertThat(customer)
                .extracting(AccountBusinessManager.CustomerInfoResponse::accounts)
                .extracting(List::size).isEqualTo(1);
    }
}