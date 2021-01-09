package org.akila.calculation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.akila.calculation.entity.Carton;
import org.akila.calculation.entity.PriceMap;
import org.akila.calculation.service.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService{

	
	public double getProductPrice(int quantity, int units, double price) {
		// Get number of cartons needed
		int noOfCartons = quantity /units;
		// Get number of units
		int noOfUnits = quantity - (noOfCartons * units);
		// calculate carton price
		double cartonCost = noOfCartons * price;
		// Apply Discount
		if (noOfCartons >= 3) {
			cartonCost *= 0.9;
		}
		double unitCost = ((price / units) * 1.3 ) * noOfUnits ;
		return cartonCost+unitCost;
	}
	
	public List<PriceMap> getPriceList(List<Carton> cartons, int startQuantity, int endQuantity) {
		List<PriceMap> priceMaps = new ArrayList<PriceMap>();
		for(int i=startQuantity; i<= endQuantity; i++) {
			PriceMap priceMap = new PriceMap();
			priceMap.setQuantity(i);
			Map<String,Double> productMap = new HashMap<String,Double>();
			for (Carton carton : cartons) {
				productMap.put(carton.getProduct().getName(), 
						this.getProductPrice(i, carton.getUnits(), carton.getPrice()));
			}
			priceMap.setProductMap(productMap);
			priceMaps.add(priceMap);
		}
		return priceMaps;
	}
	
}
