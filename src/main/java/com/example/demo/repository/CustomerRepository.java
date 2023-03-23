package com.example.demo.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByUsername(String username);

    List<Customer> findByName(String name);

    List<Customer> findByAddress(String address);

    List<Customer> findByActive(boolean active);

}
