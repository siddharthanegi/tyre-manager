package com.vaibhav.tyremanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.dto.TyreInventoryDTO;
import com.vaibhav.tyremanager.models.BusInventory;
import com.vaibhav.tyremanager.models.TyreInventory;

@Repository
public interface ITyreInventoryRepository extends JpaRepository<TyreInventory, Integer> {
	List<TyreInventory> findByThresholdFlag(String flag);

	List<TyreInventory> findByBus(BusInventory bus);
	
	@Query("SELECT new com.vaibhav.tyremanager.dto.TyreInventoryDTO("
			+ "tyreId, tyreBrand.brandName, tyreBrand.tyreManufacturer.manufacturerName, "
			+ "distanceTravelled, cost, to_char(purchaseDate, 'MM/DD/YYYY'), thresholdFlag"
			+ ") "
			+ "FROM TyreInventory WHERE bus.busId = :busId")
	List<TyreInventoryDTO> getTyreByBusId(Integer busId);
}
