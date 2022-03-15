package com.nnk.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nnk.springboot.services.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;


	// Login mapped by UserDetailsServiceImpl
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> userDetailsServiceImpl.loadUserByUsername(username))
		.passwordEncoder(passwordEncoder());
		
	} 

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**")
				.permitAll()
				.antMatchers("/user/**").authenticated()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
				.formLogin().loginPage("/app/login").permitAll().loginProcessingUrl("/app/login").defaultSuccessUrl("/", true)
				.failureUrl("/app/login?error=true")
				.and().logout().invalidateHttpSession(true).permitAll().logoutSuccessUrl("/");
		http.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 

	

}
