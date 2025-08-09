package com.diskrental.controller;

import com.diskrental.domain.Customer;
import com.diskrental.domain.Rental;
import com.diskrental.domain.model.dto.*;
import com.diskrental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${app.endpoint.api}/rental")
@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/rent/{articleIdentificationNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RentalDto> create(@PathVariable("articleIdentificationNumber") final UUID articleIdentificationNumber) {
        Rental rental = this.rentalService.rentExemplar(articleIdentificationNumber);
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

    @GetMapping("/exemplars/{articleStoreNumber}/{articleIdentificationNumber}/available")
    public ResponseEntity<List<ExemplarDto>> getAvailableExemplars(
            @PathVariable("articleIdentificationNumber") final UUID articleIdentificationNumber,
            @PathVariable("articleStoreNumber") final Integer articleStoreNumber) {
        List<ExemplarDto> dtos = this.rentalService.getAvailableExemplars(articleIdentificationNumber, articleStoreNumber);
        return ResponseEntity.ok(dtos);
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

    @GetMapping("/article/{identificationNumber}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("identificationNumber") final UUID identificationNumber) {
        ArticleDto dto = this.rentalService.getArticle(identificationNumber);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> dtos = this.rentalService.getAllCustomers();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/login/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDto> create(@PathVariable("userId") final Integer userId) {
        Customer customer = this.rentalService.login(userId);
        if (customer == null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return ResponseEntity.ok(new CustomerDto(customer));
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> getArticles() {
        List<ArticleDto> dtos = this.rentalService.getArticles();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/stores")
    public ResponseEntity<List<ArticleStoreDto>> getStores() {
        List<ArticleStoreDto> dtos = this.rentalService.getAllArticleStores();
        return ResponseEntity.ok(dtos);
    }
}
