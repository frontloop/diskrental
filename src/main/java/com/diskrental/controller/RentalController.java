package com.diskrental.controller;

import com.diskrental.domain.Rental;
import com.diskrental.domain.model.dto.RentalDto;
import com.diskrental.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("${app.endpoint.api}/rent")
@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
public class RentalController {

    private final RentalService rentalService;

    protected RentalController(RentalService service) {
        this.rentalService = service;
    }

    @PostMapping("/rent")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Rental> rent(@RequestBody RentalDto entity) {
        var rented = this.rentService.create(entity);
        RentalDto dto = new RentalDto(rented);
        return ResponseEntity.ok(dto);
    }

}
