package com.example.OneToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OneToOne.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}