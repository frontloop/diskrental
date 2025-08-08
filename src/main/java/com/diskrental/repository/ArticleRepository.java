package com.diskrental.repository;

import com.diskrental.domain.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {
    public List<Article> findAllByOrderByIdDesc();
    public List<Article> findByTitle(String title);
}
