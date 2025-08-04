package com.diskrental.domain.model.dto;

import com.diskrental.domain.Address;
import com.diskrental.domain.Store;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreDto {
    private String id;

    private String name;

    private AddressDto address;

    public StoreDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.address = new AddressDto(store.getAddress());
    }
}
