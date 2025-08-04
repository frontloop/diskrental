package com.diskrental.service;

import com.diskrental.domain.Customer;
import com.diskrental.domain.Exemplar;
import com.diskrental.domain.Rental;
import com.diskrental.domain.Store;
import com.diskrental.domain.model.dto.RentalDto;
import com.diskrental.domain.model.dto.RentalPostDto;
import com.diskrental.domain.model.dto.ReturnExemplarDto;
import com.diskrental.repository.CustomerRepository;
import com.diskrental.repository.ExemplarRepository;
import com.diskrental.repository.RentalRepository;
import com.diskrental.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    @Transactional
    public Rental create(RentalPostDto postDto) {
        List<Rental> foundOpenedRental = rentalRepository.findByExemplarIdentificationNumberAndClosedIsFalse(postDto.getExemplarIdentificationNumber());
        if (foundOpenedRental.isEmpty()) {
            Rental rental = new Rental();

            Customer customer = customerRepository.findByNumber(postDto.getCustomerNumber());
            rental.setCustomer(customer);

            Exemplar exemplar = exemplarRepository.findByIdentificationNumber(postDto.getExemplarIdentificationNumber());
            rental.setExemplar(exemplar);

            rental.setRentStartDate(LocalDateTime.now());

            rental.setPlannedReturnDate(LocalDateTime.now().plusDays(postDto.getRentalDuration()));

            rental.setOriginStore(exemplar.getStore());

            rental.setClosed(false);

            Rental savedRental = rentalRepository.save(rental);

            UUID uuid = UUID.randomUUID();

            return savedRental;
        }

        return null;
    }

    @Transactional
    public  Rental returnExemplar(ReturnExemplarDto returnExemplar) {
        List<Rental> rentalList = rentalRepository.findByExemplarIdentificationNumberAndClosedIsFalse(returnExemplar.getExemplarIdentificationNumber());

        if (rentalList.size() == 1) {
            Rental rental = rentalList.getFirst();

            Store store = storeRepository.findByNumber(returnExemplar.getStoreNumber());
            rental.setReturnStore(store);

            rental.getExemplar().setStore(store);

            rental.setReturnDate(LocalDateTime.now());

            rental.setClosed(true);

            return rentalRepository.save(rental);
        }

        return null;
    }

    @Transactional
    public List<RentalDto> getOpenRentalByCustomerNumber(Integer number) {
        List<Rental> rental = rentalRepository.findByCustomerNumberAndClosedIsFalse(number);
        return rental.stream().map(RentalDto::new).collect(Collectors.toList());
    }
}
