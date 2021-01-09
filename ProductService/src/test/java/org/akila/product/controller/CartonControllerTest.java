package org.akila.product.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.akila.product.entity.Carton;
import org.akila.product.service.CartonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CartonController.class)
public class CartonControllerTest {

    @Autowired
    private MockMvc mvc;
    
	@MockBean
	CartonService service;

    @Test
    public void test200WithoutQueryParams() throws Exception {
    	
        Carton c = new Carton();
        c.setPrice(5);
        c.setUnits(5);

        List<Carton> cartons = Arrays.asList(c);
    	
    	when(service.getAllCartons()).thenReturn(cartons);
    	
        mvc.perform(get("/cartons")
        	      .contentType(MediaType.APPLICATION_JSON))
        	      .andExpect(status().isOk());
    }
    
    @Test
    public void test200WithQueryParams() throws Exception {
    	
        Carton c = new Carton();
        c.setPrice(5);
        c.setUnits(5);

        List<Carton> cartons = Arrays.asList(c);
    	
    	when(service.getCartonsByProductName("test")).thenReturn(cartons);
    	
        mvc.perform(get("/cartons?productName=test")
        	      .contentType(MediaType.APPLICATION_JSON))
        	      .andExpect(status().isOk());
    }
}
