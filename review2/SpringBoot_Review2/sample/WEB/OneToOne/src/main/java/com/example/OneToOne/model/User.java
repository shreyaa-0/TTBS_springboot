package com.example.OneToOne.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "user_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userid;
    private String userName;
    private int userAge;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    private Address address;

    public User() {
    }

    public User(int empid, String empName, int empAge, Address address) {
        this.userid = empid;
        this.userName = empName;
        this.userAge = empAge;
        this.address = address;
    }

    public int getid() {
        return userid;
    }

    public void setEmpid(int eid) {
        this.userid = eid;
    }

    public String getName() {
        return userName;
    }

    public void setEmpName(String eName) {
        this.userName = eName;
    }

    public int getAge() {
        return userAge;
    }

    public void setAge(int eAge) {
        this.userAge = eAge;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}