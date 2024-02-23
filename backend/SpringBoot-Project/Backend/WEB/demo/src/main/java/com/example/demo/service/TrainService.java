package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepo;

@Service
public class TrainService {
    @Autowired
    TrainRepo repo;

    public Train create(Train t) {
        return repo.save(t);
        // return true;
    }

    public Train find(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Train> findA() {
        return repo.findAll();
    }

    public Train update(int id, Train t) {
        Train t1 = repo.findById(id).orElse(null);
        if (t1 != null) {
            t1.setName(t.getName());
            repo.save(t1);
            return t1;
        } else {
            return t;
        }
    }

    public void delete(int id) {
        repo.deleteById(id);

    }

}