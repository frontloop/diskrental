package com.diskrental.repository;

import com.diskrental.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, String> {
    public List<Address> findAllByOrderByIdDesc();
}
