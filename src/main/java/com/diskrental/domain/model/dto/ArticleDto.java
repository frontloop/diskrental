package com.diskrental.domain.model.dto;

import com.diskrental.domain.Article;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleDto {
    private String id;
    private String type;
    private String title;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.type = article.getType();
        this.title = article.getTitle();
    }
}
