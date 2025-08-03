package com.diskrental.repository;

import com.diskrental.domain.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RentalRepository extends MongoRepository<Rental, String> {

    public List<Rental> findByCustomerCNumber(Integer cNumber);

    List<Rental> findAllByOrderByIdDesc();

    List<Rental> findByClosedFalse();

}
