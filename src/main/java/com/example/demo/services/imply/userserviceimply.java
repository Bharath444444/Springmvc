package com.example.demo.services.imply;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.users;
import com.example.demo.repository.usersrepository;
import com.example.demo.services.usersservice;
@Service
public class userserviceimply implements usersservice {
@Autowired
private usersrepository repo;
	@Override
	public List<users> getall() {
		return repo.findAll();
	}

	@Override
	public void adduser(users u) {
	    repo.save(u);
	}

	@Override
	public void deletebyid(long id) {
		repo.deleteById(id);
	}

	@Override
	public users findbyid(long id) {
		return repo.findById(id).orElse(null);
	}

}
