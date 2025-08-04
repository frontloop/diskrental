package com.diskrental.domain;

import com.diskrental.domain.model.dto.StoreDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Store {
    @Id
    private String id;

    private Integer number;

    private String name;

    private Address address;

    public Store(StoreDto storeDto) {
        this.id = storeDto.getId();
        this.number = storeDto.getNumber();
        this.name = storeDto.getName();
        this.address = new Address(storeDto.getAddress());
    }
}
