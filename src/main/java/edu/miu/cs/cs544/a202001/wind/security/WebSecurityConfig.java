package edu.miu.cs.cs544.a202001.wind.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import edu.miu.cs.cs544.a202001.wind.service.security.UserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	    http.csrf().disable() 
	            	.authorizeRequests()
	                .antMatchers("/resources/**", "/login", "/permitswagger").permitAll() 
//	                .antMatchers("/v2/api-docs",
//                            "/configuration/ui",
//                            "/swagger-resources/**",
//                            "/configuration/security",
//                            "/swagger-ui.html",
//                            "/webjars/**").permitAll()
	                .antMatchers("/courses/").hasAnyRole("ADMIN","FACULTY")	
	                .antMatchers("/courses/**").hasRole("ADMIN")
	                .antMatchers("/session/").hasAnyRole("ADMIN","FACULTY")	
	                .antMatchers("/session/**").hasRole("ADMIN")
	                .antMatchers("/location/").hasAnyRole("ADMIN","FACULTY")	
	                .antMatchers("/location/**").hasRole("ADMIN")
	                .antMatchers("/timeSlot/").hasAnyRole("ADMIN","FACULTY")	
	                .antMatchers("/timeslot/**").hasRole("ADMIN")
	                .anyRequest().authenticated()
	                .and()
//	            .formLogin()
//	                .loginPage("/login")
//	                .permitAll()
//	                .and()
	            .logout()
	                .permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}