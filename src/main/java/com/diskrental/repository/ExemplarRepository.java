package com.diskrental.repository;

import com.diskrental.domain.Exemplar;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExemplarRepository extends MongoRepository<Exemplar, String> {
    public List<Exemplar> findAllByOrderByIdDesc();
    public List<Exemplar> findByItemTitle(String title);
}
