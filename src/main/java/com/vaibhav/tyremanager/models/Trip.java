package com.vaibhav.tyremanager.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "tripId")
@Entity(name = "TRIP")
@Data
public class Trip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8928735391518615972L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRIP_SEQ")
	@SequenceGenerator(name = "TRIP_SEQ", sequenceName = "TRIP_SEQ", allocationSize = 1)
	private Integer tripId;
	
	@Column(name="ORIGIN")
	private String origin;
	
	@Column(name="DESTINATION")
	private String destination;
	
	@Column(name="DISTANCE")
	private BigDecimal distance;
	
	@Column(name="TRIP_DATE")
	private Date tripDate;
	
	@Transient
	private String tripDateStr;
	
	@ManyToOne
	@JoinColumn(name = "BUS_ID")
	private BusInventory bus;

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	public BusInventory getBus() {
		return bus;
	}

	public void setBus(BusInventory bus) {
		this.bus = bus;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}
	
	@PrePersist
	private void setDateFromString() {
		if(null != tripDateStr) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				this.tripDate = sdf.parse(tripDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
