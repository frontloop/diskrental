package com.diskrental.repository;

import com.diskrental.domain.Exemplar;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ExemplarRepository extends MongoRepository<Exemplar, String> {
    public List<Exemplar> findAllByOrderByIdDesc();
    public List<Exemplar> findByItemTitle(String title);
    public List<Exemplar> findByItemId(String id);
    public List<Exemplar> findByItemIdAndAvailableIsTrue(String itemId);
    public Exemplar findByIdentificationNumber(UUID identificationNumber);
}
