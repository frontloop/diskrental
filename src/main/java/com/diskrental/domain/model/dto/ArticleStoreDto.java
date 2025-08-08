package com.diskrental.domain.model.dto;

import com.diskrental.domain.ArticleStore;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleStoreDto {
    private String id;

    private Integer storeNumber;

    private String name;

    private AddressDto address;

    public ArticleStoreDto(ArticleStore store) {
        this.id = store.getId();
        this.storeNumber = store.getStoreNumber();
        this.name = store.getName();
        this.address = new AddressDto(store.getAddress());
    }
}
