package com.diskrental.domain;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
public class Store {
    @Id
    private String id;

    private String name;

    @OneToOne
    private Address addres;
}
