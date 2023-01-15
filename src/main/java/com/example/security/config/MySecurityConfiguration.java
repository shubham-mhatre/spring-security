package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//using http basic auth
		//form based authentication is changed with popup/alert type of authentication in chrome for get request
		//in postmane => in request, go to authentication tab, add username and password (generated at console) and hit api
		//it will not have logout functionality
		http
		.csrf().disable()//for post, put, delete etc request we need to add csrf as false.
		.authorizeRequests()
		//.antMatchers("/public/**").permitAll() //only public url are permit without authentication.
		.antMatchers("/public/**").hasRole("Normal")//public url for normal users
		.antMatchers("/user/**").hasRole("Admin")//user url for Admin user.
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//in-memory user name and password as NoOpPasswordEncoder.
		//auth.inMemoryAuthentication().withUser("shubham").password("shubham").roles("Normal");
		//auth.inMemoryAuthentication().withUser("clientAdmin").password("abc@").roles("Admin");
		
		auth.inMemoryAuthentication().withUser("shubham")
		.password(this.bCryptpasswordEncoder().encode("shubham")).roles("Normal");
		
		auth.inMemoryAuthentication().withUser("clientAdmin")
		.password(this.bCryptpasswordEncoder().encode("abc@")).roles("Admin");
	}
	
	//required to tell which password encoder is used. currently using plain text as password.
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	public PasswordEncoder bCryptpasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	

}
