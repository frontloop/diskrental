package com.diskrental.domain.model.dto;

import com.diskrental.domain.Item;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDto {
    private String id;
    private String type;
    private String title;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.type = item.getType();
        this.title = item.getTitle();
    }
}
