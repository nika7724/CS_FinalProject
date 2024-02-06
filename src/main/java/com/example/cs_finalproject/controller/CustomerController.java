package com.example.cs_finalproject.controller;

import com.example.cs_finalproject.model.Customer;
import com.example.cs_finalproject.service.CustomerService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, @PathParam("statusId")Integer statusId) {
        Customer newCustomer = customerService.createCustomer(customer, statusId);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }


    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer newCustomer, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(customerService.updateCustomer(id, newCustomer), HttpStatus.OK);
    }
}
