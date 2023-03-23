package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin; //  KEEP
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:8081")     //  <- This is needed to make requests in browser and Postman
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers
            (@RequestParam(required = false) String username)
    {
        try{
            List<Customer> customers = new ArrayList<Customer>();
            if(username == null){
                customerRepository.findAll().forEach(customers::add);
            }
            else {
                customerRepository.findByUsername(username).forEach(customers::add);
            }
            if(customers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//END GET /customers

    @GetMapping("/customers/active")
    public ResponseEntity<List<Customer>> findByActive() {
        try {
            List<Customer> customers = customerRepository.findByActive(true);

            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//END METHOD GET/customers/active


}// END CONTROLLER
