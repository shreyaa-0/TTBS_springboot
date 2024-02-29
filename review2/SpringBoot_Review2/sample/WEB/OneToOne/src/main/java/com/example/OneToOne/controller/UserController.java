package com.example.OneToOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OneToOne.model.User;
import com.example.OneToOne.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping("/insertdata")
    public User insert(@RequestBody User e) {
        return userservice.createuser(e);
    }

    @GetMapping("/getdata")
    public List<User> get() {
        return userservice.getuser();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int empid) {
        return userservice.finduser(empid);
    }

    @PutMapping("/updatedata/{id}")
    public User update(@PathVariable int empid, @RequestBody User e) {
        return userservice.updateuser(empid, e);
    }

    @DeleteMapping("/deletedata{id}")
    public void delete(@PathVariable int empid) {
        userservice.deleteuser(empid);
    }

}