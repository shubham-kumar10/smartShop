package com.cognizant.smartShop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.smartShop.security.JwtAuthorizationFilter;
import com.cognizant.smartShop.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();

		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/register*").permitAll();

		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/authenticate")
				.hasAnyAuthority("U", "A", "S")
				.antMatchers("/admin/request").hasAuthority("S")
				.antMatchers("/admin/*").hasAuthority("S")
				.antMatchers("/admin/*").hasAuthority("S")
				.anyRequest().authenticated()
				.and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
}
