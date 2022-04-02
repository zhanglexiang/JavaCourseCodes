package com.xiang.config;

import com.xiang.properties.StudentPropertise;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StudentPropertise.class)
public class StudentConfig {
}