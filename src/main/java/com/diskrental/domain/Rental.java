package com.diskrental.domain;

import com.diskrental.domain.model.dto.RentalDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rental {
    @Id
    private String id;

    private Exemplar exemplar;

    private Customer customer;

    private LocalDateTime rentStartDate;

    private LocalDateTime plannedReturnDate;

    private LocalDateTime returnDate;

    private boolean closed;

    private ItemStore originStore;

    private ItemStore returnStore;

    public Rental(RentalDto rentalDto) {
        this.id = rentalDto.getId();
        this.exemplar = new Exemplar(rentalDto.getExemplar());
        this.customer = new Customer(rentalDto.getCustomer());
        this.rentStartDate = rentalDto.getRentStartDate();
        this.plannedReturnDate = rentalDto.getPlannedReturnDate();
        this.returnDate = rentalDto.getReturnDate();
        this.closed = rentalDto.isClosed();
        this.originStore = new ItemStore(rentalDto.getOriginStore());
        this.returnStore = new ItemStore(rentalDto.getReturnStore());
    }

    @Override
    public String toString() {
        return String.format(
                "Rental[id=%s, customer='%s']",
                id, customer);
    }
}
