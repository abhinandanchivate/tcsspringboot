package com.tcs.productrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.productrestapi.model.Product;
import com.tcs.productrestapi.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts().get();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") int productId) {
		return productService.getProductById(productId).get();
	}
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
	
	  return 	productService.createProduct(product);
	}

}
