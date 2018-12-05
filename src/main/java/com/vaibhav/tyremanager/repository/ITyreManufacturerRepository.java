package com.vaibhav.tyremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.models.TyreManufacturer;

@Repository
public interface ITyreManufacturerRepository extends JpaRepository<TyreManufacturer, Integer> {

}
