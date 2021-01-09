package org.akila.product.service.impl;

import java.util.List;

import org.akila.product.entity.Product;
import org.akila.product.repo.ProductRepository;
import org.akila.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	
	
}
