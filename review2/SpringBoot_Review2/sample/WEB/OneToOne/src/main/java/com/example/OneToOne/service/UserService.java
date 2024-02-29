package com.example.OneToOne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OneToOne.model.User;
import com.example.OneToOne.repository.UserRepo;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    // post the data
    public User createuser(User e) {
        return userRepository.save(e);
    }

    // get data
    public List<User> getuser() {
        return userRepository.findAll();
    }

    // update data
    public User updateuser(int eid, User e) {
        User s1 = userRepository.findById(eid).orElse(null);
        if (s1 != null) {
            s1.setEmpName(e.getName());
            s1.setAge(e.getAge());
            userRepository.save(s1);
            return s1;
        } else {
            return e;
        }
    }

    // getdata
    public User finduser(int eid) {
        return userRepository.findById(eid).orElse(null);
    }

    // delete the data
    public void deleteuser(int eid) {
        userRepository.deleteById(eid);
    }
}