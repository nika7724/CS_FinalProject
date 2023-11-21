package com.example.cs_finalproject.service;

import com.example.cs_finalproject.model.Customer;
import com.example.cs_finalproject.model.Status;
import com.example.cs_finalproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final StatusService statusService;

    //construction injection
    public CustomerService(final CustomerRepository customerRepository, final StatusService statusService) {
        this.customerRepository = customerRepository;
        this.statusService = statusService;
    }

    //find all customers
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
    //find a customer by id
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    //add customer
    public Customer createCustomer(Customer customer, Integer statusId) {
        Status status = statusService.getStatusById(statusId);
        customer.setStatus(status);
        return customerRepository.save(customer);
    }

    //delete customer
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    //update customer
    public Customer updateCustomer(Integer id, Customer newCustomer) {
        if(customerRepository.findById(id).isEmpty()) {
            return null;
        }
        return customerRepository.save(newCustomer);
    }
}

