package com.universite.universite.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universite.universite.entiry.Produit;
import com.universite.universite.repo.ProductRepository;

@RequestMapping
@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/produits")
	public List<Produit> produits(){
		return productRepository.findAll();
	}
	
	@GetMapping("/produits/{id}")
	public Produit findProduit(@PathVariable Long id){
		return productRepository.findById(id).get();
	}
}
