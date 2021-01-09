package org.akila.calculation.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.akila.calculation.client.ProductServiceClient;
import org.akila.calculation.entity.Carton;
import org.akila.calculation.service.CalculationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculationController.class)
public class CalculationControllerTest {

    @Autowired
    private MockMvc mvc;
    
	@MockBean
	ProductServiceClient client;
	
	@MockBean
	CalculationService calculationService;
	
    @Test
    public void test200Response() throws Exception {
    	
        Carton c = new Carton();
        c.setPrice(5);
        c.setUnits(5);

        List<Carton> cartons = Arrays.asList(c);
    	
    	when(client.getCartonsByProductName("test")).thenReturn(cartons);
    	when(calculationService.getProductPrice(5,5,5)).thenReturn(10.0);
    	
        mvc.perform(get("/calculate?productName=test&quantity=5")
        	      .contentType(MediaType.APPLICATION_JSON))
        	      .andExpect(status().isOk());
    }
    
    @Test
    public void testCartonNotFound() throws Exception {
    	
    	when(client.getCartonsByProductName("test")).thenReturn(null);
    	
        mvc.perform(get("/calculate?productName=test&quantity=5")
        	      .contentType(MediaType.APPLICATION_JSON))
        	      .andExpect(status().isNotFound());
    }
    
}