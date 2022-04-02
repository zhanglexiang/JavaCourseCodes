package com.xiang.config;

import com.xiang.properties.SchoolProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SchoolProperties.class)
public class SchoolConfig {
}