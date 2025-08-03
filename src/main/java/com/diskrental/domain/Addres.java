package com.diskrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
public class Addres {
    @Id
    private String id;

    private String street;
    private String zipCode;
    private String city;
}
