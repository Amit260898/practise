package com.in28minutes.microservices.jpa.in0.steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.microservices.jpa.in0.steps.entity.Users;

@Repository
@Transactional
public class UsersDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(Users users) {
		
		//open Transaction
		entityManager.persist(users);
		//close Transaction
		return users.getId();
	}
	
	

}
