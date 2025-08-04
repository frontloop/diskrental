package com.diskrental.repository;

import com.diskrental.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {
    public List<Item> findAllByOrderByIdDesc();
    public List<Item> findByTitle(String title);
}
