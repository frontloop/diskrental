package com.diskrental.domain;

import com.diskrental.domain.model.dto.ExemplarDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Exemplar {
    @Id
    private String id;

    private UUID identificationNumber;

    private Item item;

    private Integer condition;

    private LocalDateTime inventoriedDate;

    private ItemStore store;

    public Exemplar(ExemplarDto exemplarDto) {
        this.id = exemplarDto.getId();
        this.identificationNumber = exemplarDto.getIdentificationNumber();
        this.item = new Item(exemplarDto.getItem());
        this.condition = exemplarDto.getCondition();
        this.inventoriedDate = exemplarDto.getInventoriedDate();

    }
}
