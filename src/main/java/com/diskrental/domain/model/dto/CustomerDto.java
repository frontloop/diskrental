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

    private Integer userId;
    private String firstName;
    private String lastName;
    private AddressDto address;

    public CustomerDto(Customer customer) {
        this.userId = customer.getUserId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.address = new AddressDto(customer.getAddress());
    }
}
