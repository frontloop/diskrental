package com.diskrental.service;

import com.diskrental.domain.*;
import com.diskrental.model.dto.*;
import com.diskrental.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    @Autowired
    private ArticleRepository articleRepository;

    private Customer currentLoginData;

    public Customer login(Integer userId) {
        currentLoginData = customerRepository.findByUserId(userId);
        return currentLoginData;
    }

    @Transactional
    public Rental rentExemplar(UUID articleIdentificationNumber) {

            Rental rental = new Rental();

            Customer customer = customerRepository.findByUserId(currentLoginData.getUserId());
            rental.setCustomer(customer);

            List<Exemplar> exemplars = exemplarRepository.findByArticleIdentificationNumberAndAvailableIsTrue(articleIdentificationNumber);

            if (exemplars.isEmpty()) return null;

            Exemplar selectedExemplar = exemplars.getFirst();

            rental.setOriginStore(selectedExemplar.getCurrentStore());

            selectedExemplar.setAvailable(false);

            selectedExemplar.setCurrentStore(null);

            Exemplar savedExemplar = exemplarRepository.save(selectedExemplar);

            rental.setExemplar(savedExemplar);

            rental.setRentStartDate(LocalDateTime.now());

            rental.setClosed(false);

            return rentalRepository.save(rental);
    }

    @Transactional
    public  Rental returnExemplar(ReturnExemplarDto returnExemplar) {
        List<Rental> rentalList = rentalRepository.findByExemplarIdentificationNumberAndClosedIsFalse(returnExemplar.getExemplarIdentificationNumber());

        if (rentalList.size() == 1) {
            Rental rental = rentalList.getFirst();

            Exemplar exemplar = exemplarRepository.findByIdentificationNumber(rental.getExemplar().getIdentificationNumber());

            ArticleStore store = storeRepository.findByStoreNumber(returnExemplar.getStoreNumber());
            rental.setReturnStore(store);

            exemplar.setCurrentStore(store);
            exemplar.setAvailable(true);

            exemplarRepository.save(exemplar);

            rental.setReturnDate(LocalDateTime.now());

            rental.setClosed(true);

            exemplar.setAvailable(true);

            exemplarRepository.save(exemplar);

            return rentalRepository.save(rental);
        }

        return null;
    }

    @Transactional
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAllByOrderByIdAsc();
        return customers.stream().map(CustomerDto::new).collect(Collectors.toList());
    }



    @Transactional
    public ArticleDto getArticle(UUID identificationNumber) {
        Article article = articleRepository.findByIdentificationNumber(identificationNumber);
        return new ArticleDto(article);
    }

    @Transactional
    public List<ArticleDto> getArticles() {
        List<Article> articles = articleRepository.findAllByOrderByIdAsc();
        return articles.stream().map(ArticleDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<ExemplarDto> getAvailableExemplars(UUID identificationNumber, Integer storeNumber) {
        List<Exemplar> exemplars = exemplarRepository.findByArticleIdentificationNumberAndAvailableIsTrueAndCurrentStoreStoreNumber(identificationNumber, storeNumber);
        return exemplars.stream().map(ExemplarDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<ExemplarDto> getAllExemplars(UUID identificationNumber) {
        List<Exemplar> exemplars = exemplarRepository.findByArticleIdentificationNumber(identificationNumber);
        return exemplars.stream().map(ExemplarDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<RentalDto> getOpenRental() {
        List<Rental> rental = rentalRepository.findByClosedIsFalse();
        return rental.stream().map(RentalDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<RentalDto> getOpenRentalByUserId(Integer userId) {
        List<Rental> rental = rentalRepository.findByCustomerUserIdAndClosedIsFalse(userId);
        return rental.stream().map(RentalDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<ArticleStoreDto> getAllArticleStores() {
        List<ArticleStore> stores = storeRepository.findAllByOrderByIdAsc();
        return stores.stream().map(ArticleStoreDto::new).collect(Collectors.toList());
    }
}
