package com.example.demo.apps.config;

import com.example.demo.core.config.CoreConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CoreConfig.class)
public class DemoAppsConfig {
}
