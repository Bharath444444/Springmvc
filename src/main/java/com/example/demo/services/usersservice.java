package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.users;

public interface usersservice {
   List<users>getall();
  void  adduser(users u);
  void deletebyid(long id);
  users findbyid(long id);
}
