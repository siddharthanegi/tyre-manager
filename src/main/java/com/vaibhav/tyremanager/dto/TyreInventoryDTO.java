package com.vaibhav.tyremanager.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TyreInventoryDTO {
	
	private Integer tyreId;
	private String brandName;
	private String manufacturerName;
	private BigDecimal distanceTravelled;
	private BigDecimal cost;
	private String purchaseDate;
	private String thresholdFlag;
	
	public TyreInventoryDTO(Integer tyreId, String brandName, String manufacturerName, BigDecimal distanceTravelled,
			BigDecimal cost, String purchaseDate, String thresholdFlag) {
		this.tyreId = tyreId;
		this.brandName = brandName;
		this.manufacturerName = manufacturerName;
		this.distanceTravelled = distanceTravelled;
		this.cost = cost;
		this.purchaseDate = purchaseDate;
		this.thresholdFlag = thresholdFlag;
	}
	
}
