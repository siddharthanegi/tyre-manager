package com.vaibhav.tyremanager.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.ToString;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "brandId")
@Entity(name="TYRE_BRAND")
@ToString
public class TyreBrand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3506090906755250113L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYRE_BRAND_SEQ")
	@SequenceGenerator(name = "TYRE_BRAND_SEQ", sequenceName = "TYRE_BRAND_SEQ", allocationSize = 1)
	private Integer brandId;
	
	@ManyToOne
	@JoinColumn(name = "MANUFACTURER_ID")
	private TyreManufacturer tyreManufacturer;
	
	@Column(name = "BRAND_NAME")
	private String brandName;
	
	@Column(name = "MILEAGE")
	private BigDecimal mileage;
	
	@Column(name = "THRESHOLD")
	private BigDecimal threshold;
	
	@OneToMany(mappedBy="tyreBrand", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<TyreInventory> tyres;
	
	@OneToMany(mappedBy="brand", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<PurchaseOrder> purchaseOrders;
	
	@Transient
	private Long wornOutCount;
	
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public TyreManufacturer getTyreManufacturer() {
		return tyreManufacturer;
	}
	public void setTyreManufacturer(TyreManufacturer tyreManufacturer) {
		this.tyreManufacturer = tyreManufacturer;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public BigDecimal getMileage() {
		return mileage;
	}
	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}
	public BigDecimal getThreshold() {
		return threshold;
	}
	public void setThreshold(BigDecimal threshold) {
		this.threshold = threshold;
	}
	public Long getWornOutCount() {
		this.wornOutCount = 0l;
		if(null != this.tyres) {
			this.wornOutCount =this.tyres.stream().filter(t -> "Y".equalsIgnoreCase(t.getThresholdFlag())).count(); 
		}
		return wornOutCount;
	}
	public List<TyreInventory> getTyres() {
		return tyres;
	}
	public void setTyres(List<TyreInventory> tyres) {
		this.tyres = tyres;
	}
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}
	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}
}
