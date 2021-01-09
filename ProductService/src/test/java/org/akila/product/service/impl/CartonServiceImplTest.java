package org.akila.product.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.akila.product.entity.Carton;
import org.akila.product.entity.Product;
import org.akila.product.repo.CartonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CartonServiceImplTest {
	
	@Mock
	CartonRepository repo;
	
	@InjectMocks
	CartonServiceImpl service;
	
	List<Carton> cartons;
	
    @Before
    public void init() {
        Carton c = new Carton();
        c.setPrice(5);
        c.setUnits(5);
        
        Product p = new Product();
        p.setName("test");
        c.setProduct(p);
        
        cartons = Arrays.asList(c);
    }

	
	@Test
	public void testGetAllCartons() {
		when(repo.findAll()).thenReturn(cartons);
		assertEquals(1, service.getAllCartons().size());
	}
	
	@Test
	public void testGetCartonsByProductName() {
		when(repo.findByProductName("test")).thenReturn(cartons);
		assertEquals(1, service.getCartonsByProductName("test").size());
	}

}
