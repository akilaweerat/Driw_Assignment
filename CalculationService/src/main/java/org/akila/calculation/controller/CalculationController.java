package org.akila.calculation.controller;

import java.util.List;

import org.akila.calculation.client.ProductServiceClient;
import org.akila.calculation.entity.Carton;
import org.akila.calculation.entity.PriceMap;
import org.akila.calculation.service.CalculationService;
import org.akila.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CalculationController {

	private static Logger LOG = LoggerFactory.getLogger(CalculationController.class);
	
	@Autowired
	ProductServiceClient client;
	
	@Autowired
	CalculationService calculationService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/calculate")
	public double calculate(@RequestParam String productName, @RequestParam int quantity) {
		LOG.info("Obtaining cartons for product Name "+productName);
		List<Carton> cartons = client.getCartonsByProductName(productName);
		if (cartons == null || cartons.isEmpty()) {
			LOG.error("Cartons for "+productName+" Not found");
			throw new ProductNotFoundException();
		}
		// Get Container
		Carton c = cartons.get(0);
		return calculationService.getProductPrice(quantity, c.getUnits(), c.getPrice());
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/priceList")
	public List<PriceMap> priceList(@RequestParam int startQuantity, @RequestParam int endQuantity) throws JsonProcessingException {
		LOG.info("Processing price list");
		List<Carton> cartons = client.getCartons();
		return calculationService.getPriceList(cartons, startQuantity, endQuantity);
	}


}
