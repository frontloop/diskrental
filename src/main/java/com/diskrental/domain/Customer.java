package com.diskrental.domain;

import com.diskrental.model.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    private String id;

    private Integer userId;
    private String firstName;
    private String lastName;
    private Address address;

    public Customer() {}

    public Customer(CustomerDto customer) {
        this.id = customer.getId();
        this.userId = customer.getUserId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.address = new Address(customer.getAddress());
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, customerId='%s', firstName='%s', lastName='%s', address='%s']",
                id, userId, firstName, lastName, address);
    }
}
