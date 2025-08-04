package com.diskrental.controller;

import com.diskrental.domain.model.dto.RentalDto;
import com.diskrental.domain.model.dto.RentalPostDto;
import com.diskrental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${app.endpoint.api}/rental")
@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    /*@PostMapping("/rent")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Rental> rent(@RequestBody RentalDto entity) {
        var rented = this.rentalService.create(entity);
        RentalDto dto = new RentalDto(rented);
        return ResponseEntity.ok(dto);
    }*/

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RentalDto> create(@RequestBody RentalPostDto entity) {
        var rental = this.rentalService.create(entity).getBody();
        return ResponseEntity.ok(rental);
    }

    @GetMapping("/{number}/open")
    public ResponseEntity<List<RentalDto>> getOpenRentalByCustomerNumber(@PathVariable("number") final Integer number) {
        List<RentalDto> dtos = this.rentalService.getOpenRentalByCustomerNumber(number);
        return ResponseEntity.ok(dtos);
    }

}
