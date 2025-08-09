package com.diskrental.model.dto;

import com.diskrental.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDto {
    private String id;

    private String street;
    private String zipCode;
    private String city;

    public AddressDto(Address addres) {
        this.id = addres.getId();
        this.street = addres.getStreet();
        this.zipCode = addres.getZipCode();
        this.city = addres.getCity();
    }
}
