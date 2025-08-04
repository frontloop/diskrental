package com.diskrental.repository;

import com.diskrental.domain.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RentalRepository extends MongoRepository<Rental, String> {

    List<Rental> findAllByOrderByIdDesc();

    List<Rental> findByCustomerNumber(Integer Number);

    List<Rental> findByCustomerNumberAndClosedFalse(Integer Number);

    List<Rental> findByExemplarIdAndClosedFalse(String id);

    List<Rental> findByClosedFalse();

}
