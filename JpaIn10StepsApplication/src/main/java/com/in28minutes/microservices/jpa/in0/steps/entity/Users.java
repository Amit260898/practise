package com.in28minutes.microservices.jpa.in0.steps.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Table-User

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	protected Users() {
		
	}
	
	public Users(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	@Override
	public String toString() {
		return String.format("Users [id=%s, name=%s, role=%s]",id,name,role);
	}
	
	

}
