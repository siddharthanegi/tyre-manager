package com.vaibhav.tyremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.models.TyreBrand;

@Repository
public interface ITyreBrandRepository extends JpaRepository<TyreBrand, Integer> {

}
