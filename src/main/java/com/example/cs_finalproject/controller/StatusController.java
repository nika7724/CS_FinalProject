package com.example.cs_finalproject.controller;

import com.example.cs_finalproject.model.Customer;
import com.example.cs_finalproject.model.Status;
import com.example.cs_finalproject.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StatusController {

private final StatusService statusService;

public StatusController(final StatusService statusService) {
    this.statusService = statusService;
}

@GetMapping("/statuses")
public List<Status> getAllStatus() {
return statusService.getAllStatus();
    }

@GetMapping("/status/{id}")
public ResponseEntity<Status>getStatusById(@PathVariable("id") Integer id) {
Status status =statusService.getStatusById(id);
return new ResponseEntity<>(status, HttpStatus.OK);
    }

//    @PutMapping("/status/{id}")
//    public ResponseEntity<Status> updateStatus(@RequestBody Status newStatus, @PathVariable("id") Integer id) {
//        return new ResponseEntity<>(statusService.updateStatus(id, newStatus), HttpStatus.OK);
//    }
}

