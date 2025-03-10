package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.users;
import com.example.demo.services.usersservice;

@Controller
@RequestMapping("/users")
public class userscontroller {
   @Autowired
   private usersservice service;
    @GetMapping
   public String  listuser(Model m) {
	   m.addAttribute("users",service.getall());
	   return "users";
   }
    
   @GetMapping("/add")
   public String adduser(Model m) {
	   m.addAttribute("user",new users());
	   return "adduser";
   }
   
   @PostMapping("/save")
   public String saveuser(@ModelAttribute("user") users u) {
	   service.adduser(u);
	   return "redirect:/users";
   }
   
   @PostMapping("/update/{id}")
   public String updateuser(@ModelAttribute("user") users u,@PathVariable("id") long id ) {
	   u.setId(id);
	   service.adduser(u);
	   return "redirect:/users";
   }
   
   @GetMapping("/delete/{id}")
   public String deleteuser(@PathVariable("id")long id) {
	   service.deletebyid(id);
	   return "redirect:/users";
   }
   
   @GetMapping("/edituser/{id}")
   public String edituser(@PathVariable("id")long id,Model m) {
	   m.addAttribute("user",service.findbyid(id));
	   return "edituser";
   }
}