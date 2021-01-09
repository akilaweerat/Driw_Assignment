package org.akila.product.controller;

import java.util.List;

import org.akila.product.entity.Carton;
import org.akila.product.service.CartonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartonController {

	@Autowired
	private CartonService service;
	
	  @GetMapping("/cartons")
	  List<Carton> getContainers(@RequestParam(required = false) String productName) {
		if(productName != null && !productName.isBlank()) {
			return service.getCartonsByProductName(productName);
		}
	    return service.getAllCartons();
	  }
	  
}
