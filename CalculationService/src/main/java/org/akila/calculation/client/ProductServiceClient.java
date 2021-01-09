package org.akila.calculation.client;

import java.util.List;

import org.akila.calculation.entity.Carton;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "product-service")
public interface ProductServiceClient {
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/cartons?productName={productName}")
	 List<Carton> getCartonsByProductName(@PathVariable("productName") String productName);
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/cartons")
	 List<Carton> getCartons();

}
