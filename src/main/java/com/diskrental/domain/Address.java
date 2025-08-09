package com.diskrental.domain;

import com.diskrental.model.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    private String id;

    private String street;
    private String zipCode;
    private String city;

    public Address(AddressDto addressDto) {
        this.id = addressDto.getId();
        this.street = addressDto.getStreet();
        this.zipCode = addressDto.getZipCode();
        this.city = addressDto.getCity();
    }
}
