package org.akila.calculation.entity;

public class Carton {

	private long id;
	
	private Product product;
	
	private int units;
	
	private long price;
	
	public Carton() {
		
	};

	public Carton(long id, Product product, int units, long price) {
		super();
		this.id = id;
		this.product = product;
		this.units = units;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	
	
}
