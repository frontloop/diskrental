package com.diskrental.domain;

import com.diskrental.domain.model.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    private String id;

    private String type;

    private String title;

    public Item(ItemDto itemDto) {
        this.id = itemDto.getId();
        this.type = itemDto.getType();
        this.title = itemDto.getType();
    }
}
