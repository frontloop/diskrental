package com.diskrental.domain;

import com.diskrental.domain.model.dto.CustomerDto;
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

    private Integer number;
    private String firstName;
    private String lastName;
    private Address address;

    public Customer() {}

    public Customer(Integer number, String firstName, String lastName, Address address) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Customer(CustomerDto customer) {
        this.id = customer.getId();
        this.number = customer.getNumber();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.address = new Address(customer.getAddress());
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, number='%s', firstName='%s', lastName='%s', address='%s']",
                id, number, firstName, lastName, address);
    }
}
