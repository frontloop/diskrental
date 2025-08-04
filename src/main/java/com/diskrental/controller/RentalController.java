package com.diskrental.controller;

import com.diskrental.domain.model.dto.RentalDto;
import com.diskrental.domain.model.dto.RentalPostDto;
import com.diskrental.domain.model.dto.ReturnExemplarDto;
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

    @PostMapping("/rent")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RentalDto> create(@RequestBody RentalPostDto entity) {
        if (entity == null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        RentalDto rental = new RentalDto(this.rentalService.create(entity));
        return ResponseEntity.ok(rental);
    }

    @PutMapping("/return")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RentalDto> returnExemplar(@RequestBody ReturnExemplarDto entity) {
        if (entity == null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        RentalDto rental = new RentalDto(this.rentalService.returnExemplar(entity));
        return ResponseEntity.ok(rental);
    }

    @GetMapping("/{number}/open")
    public ResponseEntity<List<RentalDto>> getOpenRentalByCustomerNumber(@PathVariable("number") final Integer number) {
        List<RentalDto> dtos = this.rentalService.getOpenRentalByCustomerNumber(number);
        return ResponseEntity.ok(dtos);
    }

}
