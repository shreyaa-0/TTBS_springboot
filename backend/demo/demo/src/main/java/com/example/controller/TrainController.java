package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Train;
import com.example.service.TrainService;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private final TrainService trainService;

    public TrainController(com.example.service.TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping
    public ResponseEntity<List<Train>> getAllTrains() {
        List<Train> trains = trainService.getAllTrains();
        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable("id") Integer id) {
        Train train = trainService.getTrainById(id);
        if (train != null) {
            return new ResponseEntity<>(train, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Train> addTrain(@RequestBody Train train) {
        Train newTrain = trainService.addTrain(train);
        return new ResponseEntity<>(newTrain, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable("id") Integer id, @RequestBody Train train) {
        Train updatedTrain = trainService.updateTrain(id, train);
        if (updatedTrain != null) {
            return new ResponseEntity<>(updatedTrain, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable("id") Integer id) {
        trainService.deleteTrain(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}