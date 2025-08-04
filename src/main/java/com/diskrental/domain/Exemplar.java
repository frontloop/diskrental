package com.diskrental.domain;

import com.diskrental.domain.model.dto.ExemplarDto;
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
public class Exemplar {
    @Id
    private String id;

    private Item item;

    private Integer condition;

    private LocalDateTime inventoriedDate;

    private Store store;

    public Exemplar(ExemplarDto exemplarDto) {
        this.id = exemplarDto.getId();
        this.item = new Item(exemplarDto.getItem());
        this.condition = exemplarDto.getCondition();
        this.inventoriedDate = exemplarDto.getInventoriedDate();

    }
}
