package com.diskrental.repository;

import com.diskrental.domain.ArticleStore;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StoreRepository extends MongoRepository<ArticleStore, String> {
    public List<ArticleStore> findAllByOrderByIdAsc();
    public ArticleStore findByStoreNumber(Integer storeNumber);
}
