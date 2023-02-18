package com.example.demo.core.config;

import com.example.demo.core.repository.AccountRepository;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import static com.example.demo.core.sample.SampleDataUtil.*;

@Configuration
@Import({CoreDataSourceConfig.class})
@ComponentScan(basePackages = {
        "com.example.demo.core.business",
        "com.example.demo.core.service",
})
public class CoreConfig {
    @Bean
    @Profile({"local"})
    public CommandLineRunner demoData(CustomerRepository customerRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        return args -> {
            customerRepository.saveAll(sampleCustomers());
            accountRepository.save(sampleAccount());
            transactionRepository.saveAll(sampleTransactions());
        };
    }
}
