package com.vaibhav.tyremanager.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "manufacturerId")
@Table(name = "TYRE_MANUFACTURER")
@Entity
public class TyreManufacturer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8173657092042028389L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYRE_MANUFACTURER_SEQ")
	@SequenceGenerator(name = "TYRE_MANUFACTURER_SEQ", sequenceName = "TYRE_MANUFACTURER_SEQ", allocationSize = 1)
	private Integer manufacturerId;
	
	@Column(name = "MANUFACTURER_NAME")
	private String manufacturerName;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="tyreManufacturer", fetch=FetchType.LAZY )
	private List<TyreBrand> tyreBrand;
	
	public Integer getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<TyreBrand> getTyreBrand() {
		return tyreBrand;
	}
	public void setTyreBrand(List<TyreBrand> tyreBrand) {
		this.tyreBrand = tyreBrand;
	}
	@Override
	public String toString() {
		return "TyreManufacturer [manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", description=" + description + "]";
	}
}
