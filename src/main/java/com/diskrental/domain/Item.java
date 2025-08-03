package com.diskrental.domain;

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

    public Item(String type, String title) {
        this.type = type;
        this.title = title;
    }
}
