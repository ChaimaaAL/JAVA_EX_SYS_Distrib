package org.sid.Inventoryservice;

import org.sid.Inventoryservice.entities.Product;
import org.sid.Inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(ProductRepository productRepo, RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Product.class);
		return args -> {
			productRepo.save(new Product(null, "Computer Desktop HP", 900));
			productRepo.save(new Product(null, "Computer Desktop DELL", 9500));
			productRepo.save(new Product(null, "Computer Desktop MAC", 9000));
			productRepo.findAll().forEach(System.out::println);
		};
	}

}
