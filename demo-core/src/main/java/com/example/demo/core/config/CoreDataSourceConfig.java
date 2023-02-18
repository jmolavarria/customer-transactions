package com.example.demo.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(value = "com.example.demo.core.entity")
@EnableJpaRepositories("com.example.demo.core.repository")
public class CoreDataSourceConfig {
}
