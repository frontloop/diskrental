package com.diskrental.repository;

import com.diskrental.domain.Exemplar;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ExemplarRepository extends MongoRepository<Exemplar, String> {
    public List<Exemplar> findAllByOrderByIdDesc();
    public List<Exemplar> findByArticleTitle(String title);
    public List<Exemplar> findByArticleId(String id);
    public List<Exemplar> findByArticleIdentificationNumberAndAvailableIsTrue(UUID identificationNumber);
    public Exemplar findByIdentificationNumber(UUID identificationNumber);
}
