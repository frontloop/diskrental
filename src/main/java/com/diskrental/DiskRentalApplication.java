package com.diskrental;

import com.diskrental.domain.*;
import com.diskrental.repository.*;
import com.diskrental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class DiskRentalApplication implements CommandLineRunner {

    @Autowired RentalService rentalService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ArticleRepository articleRepository;

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
        articleRepository.deleteAll();
        exemplarRepository.deleteAll();

        /*
        Create stores
         */
        ArticleStore store1 = storeRepository.save(new ArticleStore(null, 1, "Store Eins", addressRepository.save(new Address(null, "Kiefernweg 44", "11111", "Berlin"))));
        ArticleStore store2 = storeRepository.save(new ArticleStore(null, 2, "Store Zwei", addressRepository.save(new Address(null, "Blumengasse 8", "22222", "Bad Hersfeld"))));

        /*
        Create articles
         */
        Article article1 = articleRepository.save(new Article(null, UUID.randomUUID(), "Blu-ray", "Film 111"));
        Article article2 = articleRepository.save(new Article(null, UUID.randomUUID(), "DVD", "Film 222"));
        Article article3 = articleRepository.save(new Article(null, UUID.randomUUID(), "Blu-ray", "Film 333"));

        /*
        Create exemplars
         */
        Exemplar exemplar1 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article1, 1, LocalDateTime.now().minusMonths(2), store1, false));
        Exemplar exemplar2 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article1, 2, LocalDateTime.now().minusMonths(2), store1, false));
        Exemplar exemplar3 = exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article1, 1, LocalDateTime.now().minusMonths(2), store1, true));

        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article1, 1, LocalDateTime.now().minusMonths(2), store2, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article1, 1, LocalDateTime.now().minusMonths(2), store2, true));

        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article2, 1, LocalDateTime.now().minusMonths(1), store1, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article2, 2, LocalDateTime.now().minusMonths(1), store1, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article2, 1, LocalDateTime.now().minusMonths(1), store1, true));

        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article2, 1, LocalDateTime.now().minusMonths(1), store1, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article2, 2, LocalDateTime.now().minusMonths(1), store2, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article2, 1, LocalDateTime.now().minusMonths(1), store2, true));

        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article3, 1, LocalDateTime.now().minusMonths(1), store1, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article3, 2, LocalDateTime.now().minusMonths(1), store1, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article3, 1, LocalDateTime.now().minusMonths(1), store2, true));

        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article3, 1, LocalDateTime.now().minusMonths(1), store2, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article3, 3, LocalDateTime.now().minusMonths(1), store2, true));
        exemplarRepository.save(new Exemplar(null, UUID.randomUUID(), article3, 4, LocalDateTime.now().minusMonths(1), store2, true));

        /*
        Create customers/user
         */
        Customer customer1 = customerRepository.save(new Customer(null, 111, "Alice", "Smith", addressRepository.save(new Address(null, "Goldbach 1", "11111", "Berlin"))));
        Customer customer2 = customerRepository.save(new Customer(null, 222, "Bob", "Smith", addressRepository.save(new Address(null, "Lindenweg 33", "22222", "Bad Hersfeld"))));

        /*
        Create some rental entries
         */
        rentalRepository.save(new Rental(null, exemplar1, customer1, LocalDateTime.now(), null, false, store1, null));
        rentalRepository.save(new Rental(null, exemplar2, customer2, LocalDateTime.now(), null, false, store1, null));
    }
}
