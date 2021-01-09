package org.akila.calculation.entity;

import java.util.Map;

public class PriceMap {

	private int quantity;
	
	private Map<String,Double> productMap;

	public Map<String, Double> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, Double> productMap) {
		this.productMap = productMap;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
