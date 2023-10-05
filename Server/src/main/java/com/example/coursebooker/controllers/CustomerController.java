package com.example.coursebooker.controllers;

import com.example.coursebooker.models.Customer;
import com.example.coursebooker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @GetMapping(value = "/customers/courses")
    public ResponseEntity getCustomersByCourse(@RequestParam(name="course", required = false) String name){
        if (name == null) {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(name), HttpStatus.FOUND);
        }
    }



}
