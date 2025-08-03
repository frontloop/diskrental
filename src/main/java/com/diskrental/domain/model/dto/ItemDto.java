package com.diskrental.domain.model.dto;

import com.diskrental.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ItemDto {
    private String id;
    private String type;
    private String title;

    private ItemDto() {
    }
    public ItemDto(Item item) {
        this.id = item.getId();
        this.type = item.getType();
        this.title = item.getTitle();
    }
}
