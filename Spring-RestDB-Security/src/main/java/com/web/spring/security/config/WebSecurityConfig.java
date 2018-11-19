package com.web.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().anyRequest().authenticated();
		//http.authorizeRequests().antMatchers("/","/api/**").permitAll().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/","/api/**").permitAll().antMatchers("/admin/**").access("hasRole('ADMIN') or hasRole('ROLE_ADMIN')");
		
		http.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,enabled from logins where username=?").authoritiesByUsernameQuery("select l.username,r.role from logins l ,roles r where l.login_id =r.login_id and l.username=?");
		
		
	}

}
