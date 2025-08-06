package com.diskrental.controller;

import com.diskrental.domain.Rental;
import com.diskrental.domain.model.dto.*;
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
        Rental rental = this.rentalService.create(entity);
        if (rental == null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return ResponseEntity.ok(new RentalDto(rental));
    }

    @PutMapping("/return")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RentalDto> returnExemplar(@RequestBody ReturnExemplarDto entity) {
        Rental rental = this.rentalService.returnExemplar(entity);
        if (rental == null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return ResponseEntity.ok(new RentalDto(rental));
    }

    @GetMapping("/open")
    public ResponseEntity<List<RentalDto>> getOpenRental() {
        List<RentalDto> dtos = this.rentalService.getOpenRental();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{userId}/open")
    public ResponseEntity<List<RentalDto>> getOpenRentalByUserId(@PathVariable("userId") final Integer userId) {
        List<RentalDto> dtos = this.rentalService.getOpenRentalByUserId(userId);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> getItems() {
        List<ItemDto> dtos = this.rentalService.getItems();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/stores")
    public ResponseEntity<List<ItemStoreDto>> getStores() {
        List<ItemStoreDto> dtos = this.rentalService.getAllItemStores();
        return ResponseEntity.ok(dtos);
    }
}
