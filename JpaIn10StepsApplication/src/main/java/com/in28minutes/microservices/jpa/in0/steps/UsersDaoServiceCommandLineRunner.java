package com.in28minutes.microservices.jpa.in0.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.microservices.jpa.in0.steps.entity.Users;
import com.in28minutes.microservices.jpa.in0.steps.service.UsersDAOService;

@Component
public class UsersDaoServiceCommandLineRunner implements CommandLineRunner{
	
	
	private static final Logger log = 
			LoggerFactory.getLogger(UsersDaoServiceCommandLineRunner.class);


	@Autowired
	private UsersDAOService usersDaoService;
	
	@Override
	public void run(String... args0) throws Exception {
		// TODO Auto-generated method stub
		Users users= new Users("Jack", "Admin");
		long insert= usersDaoService.insert(users);
		log.info("New user is created : " +users);
		
	}
	
	

}
