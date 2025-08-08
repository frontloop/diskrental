package com.diskrental.domain;

import com.diskrental.domain.model.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article {
    @Id
    private String id;

    private String type;

    private String title;

    public Article(ArticleDto articleDto) {
        this.id = articleDto.getId();
        this.type = articleDto.getType();
        this.title = articleDto.getType();
    }
}
