package com.diskrental.service;

import com.diskrental.domain.*;
import com.diskrental.domain.model.dto.*;
import com.diskrental.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.mongodb.core.MongoTemplate;

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
    private ItemRepository itemRepository;

    @Transactional
    public Rental rent(RentalPostDto postDto) {
        List<Rental> foundOpenedRental = rentalRepository.findByExemplarIdentificationNumberAndClosedIsFalse(postDto.getExemplarIdentificationNumber());
        if (foundOpenedRental.isEmpty()) {
            Rental rental = new Rental();

            Customer customer = customerRepository.findByUserId(postDto.getUserId());
            rental.setCustomer(customer);

            Exemplar exemplar = exemplarRepository.findByIdentificationNumber(postDto.getExemplarIdentificationNumber());
            rental.setExemplar(exemplar);

            exemplar.setAvailable(false);
            exemplarRepository.save(exemplar);

            rental.setRentStartDate(LocalDateTime.now());

            rental.setOriginStore(exemplar.getCurrentStore());

            rental.setClosed(false);

            Rental savedRental = rentalRepository.save(rental);

            UUID uuid = UUID.randomUUID();

            return savedRental;
        }

        return null;
    }

    @Transactional
    public  Rental returnExemplar(ReturnExemplarDto returnExemplar) {
        List<Rental> rentalList = rentalRepository.findByExemplarIdentificationNumberAndClosedIsFalse(returnExemplar.getExemplarIdentificationNumber());

        if (rentalList.size() == 1) {
            Rental rental = rentalList.getFirst();

            ItemStore store = storeRepository.findByStoreNumber(returnExemplar.getStoreNumber());
            rental.setReturnStore(store);

            rental.getExemplar().setCurrentStore(store);

            rental.setReturnDate(LocalDateTime.now());

            rental.setClosed(true);

            Exemplar exemplar = exemplarRepository.findByIdentificationNumber(rental.getExemplar().getIdentificationNumber());
            exemplar.setAvailable(true);
            exemplarRepository.save(exemplar);

            return rentalRepository.save(rental);
        }

        return null;
    }

    @Transactional
    public List<ItemDto> getItems() {
        List<Item> rental = itemRepository.findAllByOrderByIdDesc();
        return rental.stream().map(ItemDto::new).collect(Collectors.toList());
    }
    @Transactional
    public List<ExemplarDto> getAvailableExemplars(String itemId) {
        List<Exemplar> exemplars = exemplarRepository.findByItemIdAndAvailableIsTrue(itemId);
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
    public List<ItemStoreDto> getAllItemStores() {
        List<ItemStore> stores = storeRepository.findAllByOrderByIdAsc();
        return stores.stream().map(ItemStoreDto::new).collect(Collectors.toList());
    }
}
