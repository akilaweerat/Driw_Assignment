package org.akila.product.service.impl;

import java.util.List;

import org.akila.product.entity.Carton;
import org.akila.product.repo.CartonRepository;
import org.akila.product.service.CartonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartonServiceImpl implements CartonService{

	@Autowired
	private CartonRepository cartonRepo;
	
	
	@Override
	public List<Carton> getAllCartons() {
		return cartonRepo.findAll();
	}

	@Override
	public List<Carton> getCartonsByProductName(String productName) {
		return cartonRepo.findByProductName(productName);
	}

	
	
}
