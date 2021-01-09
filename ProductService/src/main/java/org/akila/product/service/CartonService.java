package org.akila.product.service;

import java.util.List;

import org.akila.product.entity.Carton;

public interface CartonService {

	public List<Carton> getAllCartons();

	public List<Carton> getCartonsByProductName(String productName);
}
