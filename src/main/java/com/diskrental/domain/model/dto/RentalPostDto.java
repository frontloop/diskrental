package com.diskrental.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalPostDto {
    private Integer customerNumber;
    private UUID identificationNumber;
    private Integer rentalDuration;
}
