package com.vaibhav.tyremanager.dto;

import lombok.Data;

@Data
public class BusInventoryDTO {
	
	private Integer busId;
//	private BusProvider busProvider;
	private String name;
//	private List<TyreInventory> tyres;
//	private List<Trip> trips;
	public BusInventoryDTO(Integer busId, String name) {
		this.busId = busId;
		this.name = name;
	}
	
}
