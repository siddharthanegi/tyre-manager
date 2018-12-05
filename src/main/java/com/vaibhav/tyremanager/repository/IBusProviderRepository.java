package com.vaibhav.tyremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.models.BusProvider;

@Repository
public interface IBusProviderRepository extends JpaRepository<BusProvider, Integer> {

}
