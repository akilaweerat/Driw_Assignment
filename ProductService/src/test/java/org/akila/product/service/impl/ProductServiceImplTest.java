package org.akila.product.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.akila.product.entity.Product;
import org.akila.product.repo.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	@Mock
	ProductRepository repo;
	
	@InjectMocks
	ProductServiceImpl service;
	
	List<Product> products;
	
    @Before
    public void init() {
        Product p = new Product();
        p.setName("test");
        
        products = Arrays.asList(p);
    }
    
	@Test
	public void testGetAllProducts() {
		when(repo.findAll()).thenReturn(products);
		assertEquals(1, service.getAllProducts().size());
	}
	
	
}
