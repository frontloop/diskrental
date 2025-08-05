package com.diskrental.domain.model.dto;

import com.diskrental.domain.ItemStore;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemStoreDto {
    private String id;

    private Integer storeNumber;

    private String name;

    private AddressDto address;

    public ItemStoreDto(ItemStore store) {
        this.id = store.getId();
        this.storeNumber = store.getStoreNumber();
        this.name = store.getName();
        this.address = new AddressDto(store.getAddress());
    }
}
