package com.diskrental.domain;

import com.diskrental.model.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article {
    @Id
    private String id;

    private UUID identificationNumber;

    private String type;

    private String title;

    public Article(ArticleDto articleDto) {
        this.id = articleDto.getId();
        this.identificationNumber = articleDto.getIdentificationNumber();
        this.type = articleDto.getType();
        this.title = articleDto.getType();
    }
}
