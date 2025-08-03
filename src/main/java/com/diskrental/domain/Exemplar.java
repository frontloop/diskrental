package com.diskrental.domain;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Exemplar {
    @Id
    private String id;

    @ManyToOne
    private Item item;

    private Integer condition;

    private LocalDateTime inventoriedDate;

    @OneToOne
    private Store store;
}
