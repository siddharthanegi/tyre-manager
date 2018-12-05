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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "busId")
@Entity(name="BUS_INVENTORY")
public class BusInventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7460022888522955847L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_INVENTORY_SEQ")
	@SequenceGenerator(name = "BUS_INVENTORY_SEQ", sequenceName = "BUS_INVENTORY_SEQ", allocationSize = 1)
	private Integer busId;
	
	@ManyToOne
	@JoinColumn(name="PROVIDER_ID")
	private BusProvider busProvider;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy="bus", fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	private List<TyreInventory> tyres;
	
	@OneToMany(mappedBy="bus", fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Trip> trips;

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public BusProvider getBusProvider() {
		return busProvider;
	}

	public void setBusProvider(BusProvider busProvider) {
		this.busProvider = busProvider;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TyreInventory> getTyres() {
		return tyres;
	}

	public void setTyres(List<TyreInventory> tyres) {
		this.tyres = tyres;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
}
