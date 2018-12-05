package com.vaibhav.tyremanager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.tyremanager.models.TyreInventory;
import com.vaibhav.tyremanager.repository.ITyreInventoryRepository;

@Service
@Transactional
public class TyreServiceImpl implements TyreService {
	
	@Autowired private ITyreInventoryRepository tyreInventory;

	@Override
	public List<TyreInventory> getAllTyres() {
		return tyreInventory.findAll();
	}

}
