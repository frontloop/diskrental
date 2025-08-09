package com.diskrental.model.dto;

import com.diskrental.domain.Article;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleDto {
    private String id;
    private UUID identificationNumber;
    private String type;
    private String title;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.identificationNumber = article.getIdentificationNumber();
        this.type = article.getType();
        this.title = article.getTitle();
    }
}
