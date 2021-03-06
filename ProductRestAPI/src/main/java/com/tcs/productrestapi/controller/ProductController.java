package com.tcs.productrestapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.productrestapi.exception.ResourceNotFoundException;
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
	public ResponseEntity<Product> getProductById(@PathVariable("id") int productId) throws ResourceNotFoundException {
		Product product = productService.getProductById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody Product product,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
	
		Product product2 = productService.createProduct(product);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(product2.getProductId());
		
		
	  return 	 ResponseEntity.created(uriComponents.toUri()).body(product2);
	}
	
	@DeleteMapping("/{id}")

	public Map<String, Boolean> deleteProductById(@PathVariable int id) throws ResourceNotFoundException { 
		Product product = productService.getProductById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		productService.deleteProduct(id);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		
		return hashMap;
	}
	
	
	@PutMapping("/{id}")
	
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id,
			@Valid @RequestBody Product product ) throws ResourceNotFoundException {
		Product product2 = productService.getProductById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		product.setProductId(id);
		Product product3 =productService.createProduct(product);
		
		return ResponseEntity.ok(product3);
	}
	
	
}
