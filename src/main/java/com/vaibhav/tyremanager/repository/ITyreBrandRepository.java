package com.vaibhav.tyremanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vaibhav.tyremanager.dto.BrandDTO;
import com.vaibhav.tyremanager.models.TyreBrand;

@Repository
public interface ITyreBrandRepository extends JpaRepository<TyreBrand, Integer> {
	
	@Query("SELECT new com.vaibhav.tyremanager.dto.BrandDTO(brandId , brandName) FROM TyreBrand where tyreManufacturer.manufacturerId = :manufacturerId")
	List<BrandDTO> getBrandsByManufacturer(@Param("manufacturerId") Integer manufacturerId);

}
