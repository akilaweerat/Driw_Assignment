package org.akila.calculation.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.akila.calculation.entity.Carton;
import org.akila.calculation.entity.PriceMap;
import org.akila.calculation.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculationServiceImplTest {

	@InjectMocks
	CalculationServiceImpl service;
	
	
	@Test
	public void testGetProductPrices() {
		// test one container price
		assertEquals(175, service.getProductPrice(20, 20, 175));
		// test single unit price
		assertEquals(214.5, service.getProductPrice(1, 5, 825));
		// test 3 cartons or more
		assertEquals(472.5, service.getProductPrice(60, 20, 175));
	}
	
	@Test
	public void testGetPriceList() {
        Carton c = new Carton();
        c.setPrice(5);
        c.setUnits(5);
        
        Product p = new Product();
        p.setName("test");
        c.setProduct(p);
        
        List<Carton> cartons = Arrays.asList(c);
        List<PriceMap> pMap =  service.getPriceList(cartons, 1, 5);
        assertEquals(5, pMap.size());
	}
	
}
