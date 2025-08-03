package com.diskrental.domain.model.dto;

import com.diskrental.domain.Exemplar;
import com.diskrental.domain.Rental;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalDto {

    private String id;

    private ExemplarDto exemplar;

    public RentalDto(Rental rental) {
        this.id = rental.getId();
        this.exemplar = new ExemplarDto(rental.getExemplar());
    }
}
