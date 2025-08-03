package com.diskrental.domain;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Rental {
    @Id
    private String id;

    @OneToOne
    private Exemplar exemplar;

    private LocalDateTime rented;

    private LocalDateTime plannedReturn;

    private LocalDateTime returnDate;

    @OneToOne
    private Store originStore;

    @OneToOne
    private Store returnStore;
}
