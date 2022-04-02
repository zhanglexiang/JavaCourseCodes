package com.xiang.config;

import com.xiang.properties.KlassProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KlassProperties.class)
public class KlassConfig {
}