package com.diskrental.service;

import com.diskrental.domain.Rental;
import com.diskrental.domain.model.dto.RentalDto;
import com.diskrental.repository.RentalRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<RentalDto> getAll() {
        final List<Rental> rented = rentalRepository.findAllByOrderByIdDesc();
        return rented.stream().map(RentalDto::new).collect(Collectors.toList());
    }
}
