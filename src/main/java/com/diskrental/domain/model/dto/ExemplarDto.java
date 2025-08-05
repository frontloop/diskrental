package com.diskrental.domain.model.dto;

import com.diskrental.domain.Exemplar;
import com.diskrental.domain.ItemStore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExemplarDto {

    private String id;

    private UUID identificationNumber;

    private ItemDto item;

    private Integer condition;

    private LocalDateTime inventoriedDate;

    private ItemStore currentStore;

    private Boolean available;

    public ExemplarDto(Exemplar exemplar) {
        this.id = exemplar.getId();
        this.identificationNumber = exemplar.getIdentificationNumber();
        this.item = new ItemDto(exemplar.getItem());
        this.condition = exemplar.getCondition();
    }
}
