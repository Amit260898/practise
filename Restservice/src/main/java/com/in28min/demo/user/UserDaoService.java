package com.in28min.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component

public class UserDaoService {
	private static List<User> users =new ArrayList<>();
	
	private static int usersCount=3;
	
	static{
		users.add(new User(1,"Amit",new Date()));
		users.add(new User(2,"Sumit",new Date()));
		users.add(new User(3,"Amit",new Date()));
	}
	public List<User> findAll(){
		return users;
	}
	public User save(User user){
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	//public List<User> findAll()
	//public List<User> save(User user)
	//public List<User> findOne(int id)
	
	

	public User deleteById(int id) {
		// TODO Auto-generated method stub
		Iterator<User> iterator=users.listIterator();
		while(iterator.hasNext()) {
		User user =iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
