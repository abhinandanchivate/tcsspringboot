package com.tcs.productrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String getProducts() {
		return "product";
	}
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
	
	  return 	productService.createProduct(product);
	}

}
