package com.vaibhav.tyremanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.dto.BusInventoryDTO;
import com.vaibhav.tyremanager.models.BusInventory;
import com.vaibhav.tyremanager.models.BusProvider;

@Repository
public interface IBusInventoryRepository extends JpaRepository<BusInventory, Integer> {

	List<BusInventory> findByBusProvider(BusProvider provider);

	@Query("SELECT new com.vaibhav.tyremanager.dto.BusInventoryDTO(busId, name) FROM BusInventory WHERE busProvider.providerId = :providerId")
	List<BusInventoryDTO> findByBusProviderId(@Param("providerId") Integer providerId);

}
