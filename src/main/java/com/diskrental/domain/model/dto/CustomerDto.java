package com.diskrental.domain.model.dto;

import com.diskrental.domain.Customer;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private String id;

    private Integer number;
    private String firstName;
    private String lastName;
    private AddressDto address;

    public CustomerDto(Customer customer) {
        this.number = customer.getNumber();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.address = new AddressDto(customer.getAddress());
    }
}
