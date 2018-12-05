package com.vaibhav.tyremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.models.BusInventory;

@Repository
public interface IBusInventoryRepository extends JpaRepository<BusInventory, Integer> {

}
