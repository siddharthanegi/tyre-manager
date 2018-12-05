package com.vaibhav.tyremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.models.Trip;

@Repository
public interface ITripRepository extends JpaRepository<Trip, Integer> {

}
