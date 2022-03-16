package com.nnk.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nnk.springboot.services.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	Logger logger =LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	public void configure( AuthenticationManagerBuilder auth) throws Exception, UsernameNotFoundException {
		auth.userDetailsService(username -> userDetailsServiceImpl.loadUserByUsername(username));
		logger.info("in configure AUthenticationManagerBuilder");
	} 

	@Override
	public void configure( HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/css/**")
				.permitAll()
				.antMatchers("/user/**, /bidList/**,/curvePoint/**,/rating/**,/ruleName/**,/trade/**").authenticated()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
				.formLogin().loginPage("/app/login").permitAll().loginProcessingUrl("/app/login").defaultSuccessUrl("/bidlist/list", true)
				.failureUrl("/app/login?error=true")
				.and().logout().invalidateHttpSession(true).permitAll().logoutSuccessUrl("/");
		// désactivation de la protection CSRF
		// non utilisée dans le cadre d'une Web API
		http.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 

	

}
