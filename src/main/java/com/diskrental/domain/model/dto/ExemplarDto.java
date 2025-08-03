package com.diskrental.domain.model.dto;

import com.diskrental.domain.Exemplar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExemplarDto {

    private String id;

    private ItemDto item;

    private Integer condition;

    private LocalDateTime inventoriedDate;

    public ExemplarDto(Exemplar exemplar) {
        this.id = exemplar.getId();
        this.item = new ItemDto(exemplar.getItem());
        this.condition = exemplar.getCondition();
    }
}
