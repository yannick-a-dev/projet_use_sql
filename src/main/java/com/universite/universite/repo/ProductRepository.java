package com.universite.universite.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.universite.universite.entiry.Produit;

public interface ProductRepository extends JpaRepository<Produit, Long> {

	List<Produit> findByNameContains(String mc);
	
	List<Produit> findByPriceGreaterThan(double price);
	
	@Query("select p from Produit p where p.name like :x")
	List<Produit> search(@Param("x") String mc);
	
	@Query("select p from Produit p where p.price > :x")
	List<Produit> searchByPrice(@Param("x") double price);

	Produit findByName(String name);
}
