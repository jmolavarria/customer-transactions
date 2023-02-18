package com.example.demo.core.config;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(CoreConfig.class)
@DataJpaTest
public class DemoCoreConfigTest {
}
