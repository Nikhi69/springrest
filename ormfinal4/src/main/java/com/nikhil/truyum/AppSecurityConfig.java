//package com.nikhil.truyum;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.nikhil.truyum.service.AppUserDetailsService;
//
//
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
////	@Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//////      super.configure(auth);
////      auth.inMemoryAuthentication()
////          .withUser("user")
////         .password(passwordEncoder().encode("userpwd"))
////         .roles("REG")
////         .and()
////         .withUser("admin")
////         .password(passwordEncoder().encode("adminpwd"))
////         .roles("admin");
////    }
//	
//	@Autowired
//	AppUserDetailsService appUserDetailsService;
//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
//}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http.authorizeRequests()
//		.antMatchers("/adminlist","/editmovie","/movielistAdmin").hasRole("admin")
//		.antMatchers("/movielistCustomer","/addfavt","/viewfavt","/removeItem").hasRole("user")
//		.and().formLogin();
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}