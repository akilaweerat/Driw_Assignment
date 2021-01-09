package org.akila.calculation.service;

import java.util.List;

import org.akila.calculation.entity.Carton;
import org.akila.calculation.entity.PriceMap;

public interface CalculationService {
	
	double getProductPrice(int quantity, int units, double price);
	
	List<PriceMap> getPriceList(List<Carton> cartons, int startQuantity, int endQuantity);
}
