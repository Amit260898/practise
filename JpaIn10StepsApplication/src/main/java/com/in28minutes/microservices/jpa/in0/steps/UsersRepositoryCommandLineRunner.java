package com.in28minutes.microservices.jpa.in0.steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.microservices.jpa.in0.steps.entity.Users;
import com.in28minutes.microservices.jpa.in0.steps.service.UsersDAOService;
import com.in28minutes.microservices.jpa.in0.steps.service.UsersRepository;

@Component
public class UsersRepositoryCommandLineRunner implements CommandLineRunner{
	
	
	private static final Logger log = 
			LoggerFactory.getLogger(UsersRepositoryCommandLineRunner.class);


	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public void run(String... args0) throws Exception {
		// TODO Auto-generated method stub
		Users users= new Users("Jill", "Admin");
		usersRepository.save(users);
		Optional<Users> usersWithIdOne = usersRepository.findById(1L);
		log.info("user is retrieved : " +usersWithIdOne);
		
		List<Users> users2 = usersRepository.findAll();
		log.info("All users : " +users2);
		
	}
	
	

}
