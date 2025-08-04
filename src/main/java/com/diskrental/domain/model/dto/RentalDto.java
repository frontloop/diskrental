package com.diskrental.domain.model.dto;

import com.diskrental.domain.Rental;
import com.diskrental.domain.Store;
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

    private CustomerDto customer;

    private LocalDateTime rentStartDate;

    private LocalDateTime plannedReturnDate;

    private LocalDateTime returnDate;

    private boolean closed;

    private StoreDto originStore;

    private StoreDto returnStore;

    public RentalDto(Rental rental) {
        this.id = rental.getId();
        this.exemplar = new ExemplarDto(rental.getExemplar());
        this.customer = new CustomerDto(rental.getCustomer());
        this.rentStartDate = rental.getRentStartDate();
        this.plannedReturnDate = rental.getPlannedReturnDate();
        this.returnDate = rental.getReturnDate();
        this.closed = rental.isClosed();
        this.originStore = new StoreDto(rental.getOriginStore());
        this.returnStore = new StoreDto(rental.getOriginStore());
    }
}
