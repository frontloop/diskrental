package com.diskrental.domain;

import com.diskrental.domain.model.dto.ItemStoreDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemStore {
    @Id
    private String id;

    private Integer storeNumber;

    private String name;

    private Address address;

    public ItemStore(ItemStoreDto itemStoreDto) {
        this.id = itemStoreDto.getId();
        this.storeNumber = itemStoreDto.getStoreNumber();
        this.name = itemStoreDto.getName();
        this.address = new Address(itemStoreDto.getAddress());
    }
}
