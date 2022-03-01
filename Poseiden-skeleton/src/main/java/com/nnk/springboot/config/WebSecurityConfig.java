package com.nnk.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nnk.springboot.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// Login mapped by UserDetailsServiceImpl
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> userDetailsServiceImpl.loadUserByUsername(username))
		.passwordEncoder(passwordEncoder);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/user/add", "/css/**")
				.permitAll().antMatchers("/user/**").authenticated().antMatchers("/admin/**").hasRole("ADMIN").and()
				.formLogin().loginPage("/app/login").permitAll().loginProcessingUrl("/app/login").defaultSuccessUrl("/")
				.and().logout().invalidateHttpSession(true).permitAll().logoutSuccessUrl("/");
		http.csrf().disable();
	}

	

}
