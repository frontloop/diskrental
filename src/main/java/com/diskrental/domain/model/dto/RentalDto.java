package com.diskrental.domain.model.dto;

import com.diskrental.domain.Rental;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalDto {

    private String id;

    private ExemplarDto exemplar;

    private LocalDateTime rentStartDate;

    private LocalDateTime plannedReturnDate;

    private LocalDateTime returnDate;

    private boolean available;

    public RentalDto(Rental rental) {
        this.id = rental.getId();
        this.exemplar = new ExemplarDto(rental.getExemplar());
        this.rentStartDate = rental.getRentStartDate();
        this.plannedReturnDate = rental.getPlannedReturnDate();
        this.returnDate = rental.getReturnDate();
        this.available = rental.isAvailable();
    }
}
