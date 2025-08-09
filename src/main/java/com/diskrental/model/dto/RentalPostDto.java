package com.diskrental.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalPostDto {
    private Integer userId;
    private UUID exemplarIdentificationNumber;
    private Integer rentalDuration;
}
