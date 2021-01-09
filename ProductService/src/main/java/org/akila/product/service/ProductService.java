package org.akila.product.service;

import java.util.List;

import org.akila.product.entity.Product;

public interface ProductService {

	/**
	 * Retrieves all products
	 * @return list of products
	 */
	List<Product> getAllProducts();
	
}
