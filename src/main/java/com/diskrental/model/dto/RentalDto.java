package com.diskrental.model.dto;

import com.diskrental.domain.Rental;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalDto {

    private String id;

    private ExemplarDto exemplar;

    private CustomerDto customer;

    private LocalDateTime rentStartDate;

    private LocalDateTime returnDate;

    private boolean closed;

    private ArticleStoreDto originStore;

    private ArticleStoreDto returnStore;

    public RentalDto(Rental rental) {
        this.id = rental.getId();
        this.exemplar = new ExemplarDto(rental.getExemplar());
        this.customer = new CustomerDto(rental.getCustomer());
        this.rentStartDate = rental.getRentStartDate();
        this.returnDate = rental.getReturnDate();
        this.closed = rental.isClosed();
        this.originStore = new ArticleStoreDto(rental.getOriginStore());
        if (rental.getReturnStore() != null) {
            this.returnStore = new ArticleStoreDto(rental.getReturnStore());
        }
    }
}
