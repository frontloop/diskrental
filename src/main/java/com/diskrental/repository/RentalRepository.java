package com.diskrental.repository;

import com.diskrental.domain.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RentalRepository extends MongoRepository<Rental, String> {

    List<Rental> findAllByOrderByIdDesc();

    List<Rental> findByCustomerNumber(Integer Number);

    List<Rental> findByCustomerNumberAndClosedIsFalse(Integer Number);

    List<Rental> findByClosedIsFalse();

    List<Rental> findByExemplarIdentificationNumberAndClosedIsFalse(UUID id);

    List<Rental> findByExemplarIdAndClosedIsFalse(String id);

    List<Rental> findByClosedFalse();

}
