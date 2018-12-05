package com.vaibhav.tyremanager.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vaibhav.tyremanager.models.PurchaseOrder;

public interface IPurchaseOrderRepository extends PagingAndSortingRepository<PurchaseOrder, Integer> {

}
