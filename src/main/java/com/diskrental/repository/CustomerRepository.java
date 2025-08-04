package com.diskrental.repository;

import java.util.List;

import com.diskrental.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    public Customer findByNumber(Integer number);

}
