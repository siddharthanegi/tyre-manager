package com.vaibhav.tyremanager.service;

import java.util.List;

import com.vaibhav.tyremanager.dto.TyreInventoryDTO;
import com.vaibhav.tyremanager.models.TyreInventory;

public interface TyreService {
	
	List<TyreInventory> getAllTyres();
	List<TyreInventory> wornOutTyres();
	List<TyreInventoryDTO> getTyresByBus(Integer busId);
	
}
