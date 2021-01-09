package org.akila.product.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.akila.product.entity.Carton;
import org.akila.product.entity.Product;
import org.akila.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
    @Autowired
    private MockMvc mvc;
    
	@MockBean
	ProductService service;
	

    @Test
    public void test200Response() throws Exception {
    	
    	Product p = new Product();
    	p.setName("test");

        List<Product> products = Arrays.asList(p);
    	
    	when(service.getAllProducts()).thenReturn(products);
    	
        mvc.perform(get("/products")
        	      .contentType(MediaType.APPLICATION_JSON))
        	      .andExpect(status().isOk());
    }

}
