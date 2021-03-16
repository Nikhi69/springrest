package com.nikhil.truyum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nikhil.truyum.service.MovieService;
import com.nikhil.truyum.service.UserService;

@SpringBootApplication
public class TruyummenuApplication {
	@Autowired
	static MovieService movieService;
	@Autowired
	static UserService userService;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TruyummenuApplication.class, args);
		movieService = context.getBean(MovieService.class);
		userService = context.getBean(UserService.class);
	}

}
