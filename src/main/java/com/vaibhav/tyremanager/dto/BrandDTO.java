package com.vaibhav.tyremanager.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BrandDTO {

	private Integer brandId;
	private String brandName;
	private BigDecimal mileage;
	private BigDecimal threshold;
	
	public BrandDTO(Integer brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}
}
