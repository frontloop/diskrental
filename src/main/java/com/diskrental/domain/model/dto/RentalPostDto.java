package com.diskrental.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalPostDto {
    private Integer customerNumber;
    private String exemplarId;
    private Integer rentalDuration;
}
