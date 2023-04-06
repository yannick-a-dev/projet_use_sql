package com.universite.universite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.universite.universite.entiry.Produit;
import com.universite.universite.repo.ProductRepository;

@SpringBootApplication
public class UniversiteApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UniversiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Produit(null,"Computer", 455, 3));
		productRepository.save(new Produit(null,"Printer", 40000, 2));
		productRepository.save(new Produit(null,"Smart", 400055, 1));
		List<Produit> products = productRepository.findAll();
		products.forEach(p -> {
			System.out.println(p.toString());
		});
		Produit product = productRepository.findById(Long.valueOf(1)).get();
		System.out.println("****************");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQuantity());
		System.out.println("**********************");
		System.out.println("-----------------");
		List<Produit> productList = productRepository.findByNameContains("C");
		productList.forEach(p->{
			System.out.println(p);
		});
		System.out.println("*******************");
		List<Produit> productList1 = productRepository.search("%S%");
		productList1.forEach(p->{
			System.out.println(p);
		});
		System.out.println("-------------");
	
		List<Produit> productList2 = productRepository.searchByPrice(400);
		productList2.forEach(p->{
			System.out.println(p);
		});
	}

}
