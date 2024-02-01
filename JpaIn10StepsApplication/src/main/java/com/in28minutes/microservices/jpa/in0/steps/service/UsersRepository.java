package com.in28minutes.microservices.jpa.in0.steps.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.microservices.jpa.in0.steps.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
