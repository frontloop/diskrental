package com.diskrental.domain;

import com.diskrental.model.dto.ArticleStoreDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleStore {
    @Id
    private String id;

    private Integer storeNumber;

    private String name;

    private Address address;

    public ArticleStore(ArticleStoreDto articleStoreDto) {
        this.id = articleStoreDto.getId();
        this.storeNumber = articleStoreDto.getStoreNumber();
        this.name = articleStoreDto.getName();
        this.address = new Address(articleStoreDto.getAddress());
    }
}
