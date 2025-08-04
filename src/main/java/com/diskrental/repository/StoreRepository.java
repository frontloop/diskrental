package com.diskrental.repository;

import com.diskrental.domain.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StoreRepository extends MongoRepository<Store, String> {
    public List<Store> findAllByOrderByIdDesc();
    public Store findByNumber(Integer number);
}
