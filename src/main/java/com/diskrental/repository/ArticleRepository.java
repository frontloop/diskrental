package com.diskrental.repository;

import com.diskrental.domain.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends MongoRepository<Article, String> {
    public List<Article> findAllByOrderByIdAsc();
    public List<Article> findByTitle(String title);
    public Article findByIdentificationNumber(UUID identificationNumber);
}
