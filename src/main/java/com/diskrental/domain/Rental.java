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

    private LocalDateTime rentStartDate;

    private LocalDateTime plannedReturnDate;

    private LocalDateTime returnDate;

    private boolean closed;

    @OneToOne
    private Store originStore;

    @OneToOne
    private Store returnStore;
}
