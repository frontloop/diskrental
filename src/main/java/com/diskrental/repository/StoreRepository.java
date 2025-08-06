package com.diskrental.repository;

import com.diskrental.domain.ItemStore;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StoreRepository extends MongoRepository<ItemStore, String> {
    public List<ItemStore> findAllByOrderByIdAsc();
    public ItemStore findByStoreNumber(Integer storeNumber);
}
