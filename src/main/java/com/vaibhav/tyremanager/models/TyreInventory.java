package com.vaibhav.tyremanager.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "tyreId")
@Table(name = "TYRE_INVENTORY")
@Entity
public class TyreInventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2876609798438176433L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYRE_INVENTORY_SEQ")
	@SequenceGenerator(name = "TYRE_INVENTORY_SEQ", sequenceName = "TYRE_INVENTORY_SEQ", allocationSize = 1)
	private Integer tyreId;
	
	@ManyToOne
	@JoinColumn(name = "BRAND_ID")
	private TyreBrand tyreBrand;
	
	@ManyToOne
	@JoinColumn(name = "BUS_ID")
	private BusInventory bus;
	
	@Column(name = "DISTANCE_TRAVELLED")
	private BigDecimal distanceTravelled;
	
	@Column(name = "COST")
	private BigDecimal cost;
	
	@Column(name = "PURCHASE_DATE")
	private Date purchaseDate;
	
	@Column(name = "THRESHOLD_FLAG")
	private String thresholdFlag;

	public Integer getTyreId() {
		return tyreId;
	}

	public void setTyreId(Integer tyreId) {
		this.tyreId = tyreId;
	}

	public TyreBrand getTyreBrand() {
		return tyreBrand;
	}

	public void setTyreBrand(TyreBrand tyreBrand) {
		this.tyreBrand = tyreBrand;
	}

	public BusInventory getBusInventory() {
		return bus;
	}

	public void setBusInventory(BusInventory busInventory) {
		this.bus = busInventory;
	}

	public BigDecimal getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(BigDecimal distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public String getThresholdFlag() {
		return thresholdFlag;
	}

	public void setThresholdFlag(String thresholdFlag) {
		this.thresholdFlag = thresholdFlag;
	}

	public BusInventory getBus() {
		return bus;
	}

	public void setBus(BusInventory bus) {
		this.bus = bus;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
}
