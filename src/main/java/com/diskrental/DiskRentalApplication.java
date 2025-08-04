package com.diskrental;

import com.diskrental.domain.*;
import com.diskrental.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class DiskRentalApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    public static void main(String[] args) {
        SpringApplication.run(DiskRentalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();
        addressRepository.deleteAll();
        storeRepository.deleteAll();
        rentalRepository.deleteAll();
        itemRepository.deleteAll();
        exemplarRepository.deleteAll();

        Store store1 = storeRepository.save(new Store(null, "Store 111", addressRepository.save(new Address(null, "Kiefernweg 44", "11111", "Berlin"))));
        Store store2 = storeRepository.save(new Store(null, "Store 222", addressRepository.save(new Address(null, "Blumengasse 8", "22222", "Bad Hersfeld"))));

        Item item1 = itemRepository.save(new Item(null, "Blu-ray", "Film 111"));
        Item item2 = itemRepository.save(new Item(null, "DVD", "Film 222"));
        Item item3 = itemRepository.save(new Item(null, "Blu-ray", "Film 333"));

        Exemplar exemplar1 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), item1, 1, LocalDateTime.now().minusMonths(2), store1));
        Exemplar exemplar2 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), item1, 2, LocalDateTime.now().minusMonths(2), store1));
        Exemplar exemplar3 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), item1, 1, LocalDateTime.now().minusMonths(2), store1));

        Exemplar exemplar4 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), item1, 1, LocalDateTime.now().minusMonths(2), store2));
        Exemplar exemplar5 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), item1, 1, LocalDateTime.now().minusMonths(2), store2));

        Exemplar exemplar6 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), item2, 1, LocalDateTime.now().minusMonths(1), store1));
        Exemplar exemplar7 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), item2, 2, LocalDateTime.now().minusMonths(1), store1));
        Exemplar exemplar8 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), item2, 1, LocalDateTime.now().minusMonths(1), store1));

        // save a couple of customers
        Customer customer1 = customerRepository.save(new Customer(111, "Alice", "Smith", addressRepository.save(new Address(null, "Goldbach 1", "11111", "Berlin"))));
        Customer customer2 = customerRepository.save(new Customer(222, "Bob", "Smith", addressRepository.save(new Address(null, "Lindenweg 33", "22222", "Bad Hersfeld"))));

        rentalRepository.save(new Rental(null, exemplar1, customer1, LocalDateTime.now(), LocalDateTime.now().plusDays(2), null, false, store1, null));
        rentalRepository.save(new Rental(null, exemplar2, customer2, LocalDateTime.now(), LocalDateTime.now().plusDays(2), null, false, store1, null));

        System.out.println("All exemplars:");
        System.out.println("-------------------------------");
        for (Exemplar exemplar : exemplarRepository.findAllByOrderByIdDesc()) {
            System.out.println(exemplar.getId() + " - " + exemplar.getIdentificationNumber());
        }
        System.out.println();


        List<Rental> notClosed = rentalRepository.findByExemplarIdentificationNumberAndClosedIsFalse(exemplar1.getIdentificationNumber());

        System.out.println("Not closed rental found:");
        System.out.println("-------------------------------");
        System.out.println(notClosed.size());

        System.out.println();

        System.out.println("Rentals found with customer number 111:");
        System.out.println("-------------------------------");
        for (Rental rental : rentalRepository.findByCustomerNumberAndClosedIsFalse(111)) {
            System.out.println(rental);
        }
        System.out.println();

        List<Customer> foundCustomer = customerRepository.findByFirstNameAndLastName("Bob", "Smith");

        System.out.println("Found customer by first and last name:");
        System.out.println("-------------------------------");
        System.out.println(foundCustomer.size());

        /*System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();*/

        /*System.out.println("Address found with findAll():");
        System.out.println("-------------------------------");
        for (Address address : addressRepository.findAll()) {
            System.out.println(address);
        }
        System.out.println();*/

        // fetch an individual customer
        /*System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(customerRepository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : customerRepository.findByLastName("Smith")) {
            System.out.println(customer);
        }*/
    }

}
