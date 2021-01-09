package org.akila.product.controller;

import java.util.List;

import org.akila.product.entity.Product;
import org.akila.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	  @CrossOrigin(origins = "*")
	  @GetMapping("/products")
	  List<Product> all() {
	    return service.getAllProducts();
	  }

}
