package com.xiang;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application {

	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
		} catch (Exception e) {
			log.error("", e);
		}
	}
	
}
