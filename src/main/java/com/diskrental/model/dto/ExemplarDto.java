package com.diskrental.model.dto;

import com.diskrental.domain.Exemplar;
import com.diskrental.domain.ArticleStore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExemplarDto {

    private String id;

    private UUID identificationNumber;

    private ArticleDto article;

    private Integer condition;

    private LocalDateTime inventoriedDate;

    private ArticleStore currentStore;

    private Boolean available;

    public ExemplarDto(Exemplar exemplar) {
        this.id = exemplar.getId();
        this.identificationNumber = exemplar.getIdentificationNumber();
        this.article = new ArticleDto(exemplar.getArticle());
        this.condition = exemplar.getCondition();
        this.currentStore = exemplar.getCurrentStore();
        this.inventoriedDate = exemplar.getInventoriedDate();
        this.available = exemplar.isAvailable();
    }
}
