package com.example.demo.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        
        Long customerId;
        Long balance;

        public Account() {
        }

        public Account(Long customerId, Long balance) {
                this.customerId = customerId;
                this.balance = balance;
        }
}
