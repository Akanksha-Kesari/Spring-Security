package com.web.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
	@Bean(name="datasource")
			public DriverManagerDataSource dataSource()
			{
			DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("dbc:oracle:thin:@127.0.0.1:1521:XE");
			driverManagerDataSource.setUsername("SYSTEM");
			driverManagerDataSource.setPassword("SYSTEM");
			return driverManagerDataSource;
			}
}
