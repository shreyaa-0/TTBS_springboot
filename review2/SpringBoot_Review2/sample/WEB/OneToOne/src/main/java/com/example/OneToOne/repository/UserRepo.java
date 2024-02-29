package com.example.OneToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OneToOne.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}