package com.diskrental.service;

import com.diskrental.domain.Customer;
import com.diskrental.domain.Exemplar;
import com.diskrental.domain.Rental;
import com.diskrental.domain.model.dto.RentalDto;
import com.diskrental.domain.model.dto.RentalPostDto;
import com.diskrental.repository.CustomerRepository;
import com.diskrental.repository.ExemplarRepository;
import com.diskrental.repository.RentalRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    @Transactional
    public ResponseEntity<RentalDto> create(RentalPostDto postDto) {
        List<Rental> foundOpenedRental = rentalRepository.findByExemplarIdentificationNumberAndClosedIsFalse(postDto.getIdentificationNumber());
        if (foundOpenedRental.isEmpty()) {
            Rental rental = new Rental();

            Customer customer = customerRepository.findByNumber(postDto.getCustomerNumber());
            rental.setCustomer(customer);

            Exemplar exemplar = exemplarRepository.findByIdentificationNumber(postDto.getIdentificationNumber());
            rental.setExemplar(exemplar);

            rental.setRentStartDate(LocalDateTime.now());

            rental.setPlannedReturnDate(LocalDateTime.now().plusDays(postDto.getRentalDuration()));

            rental.setOriginStore(exemplar.getStore());

            rental.setClosed(false);

            Rental savedRental = rentalRepository.save(rental);

            UUID uuid = UUID.randomUUID();

            return ResponseEntity.ok(new RentalDto(savedRental));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(null);
    }

    @Transactional
    public List<RentalDto> getOpenRentalByCustomerNumber(Integer number) {
        List<Rental> rental = rentalRepository.findByCustomerNumberAndClosedIsFalse(number);
        return rental.stream().map(RentalDto::new).collect(Collectors.toList());
    }
}
