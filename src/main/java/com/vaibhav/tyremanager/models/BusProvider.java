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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "providerId")
@Entity(name = "BUS_PROVIDER")
public class BusProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5805031380170755437L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_PROVIDER_SEQ")
	@SequenceGenerator(name = "BUS_PROVIDER_SEQ", sequenceName = "BUS_PROVIDER_SEQ", allocationSize = 1)
	private Integer providerId;
	
	@Column(name = "PROVIDER_NAME")
	private String providerName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy="busProvider", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<BusInventory> buses;
	
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<BusInventory> getBuses() {
		return buses;
	}
	public void setBuses(List<BusInventory> buses) {
		this.buses = buses;
	}
}
