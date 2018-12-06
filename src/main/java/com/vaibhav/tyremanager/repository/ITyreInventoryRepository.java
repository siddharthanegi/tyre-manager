package com.vaibhav.tyremanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.models.TyreInventory;

@Repository
public interface ITyreInventoryRepository extends JpaRepository<TyreInventory, Integer> {
	List<TyreInventory> findByThresholdFlag(String flag);
}
