package com.vaibhav.tyremanager.service;

import java.util.List;

import com.vaibhav.tyremanager.models.Trip;

public interface TripService {
	
	Trip addTrip(Trip trip);
	Trip getTrip(Integer tripId);
	List<Trip> getAllTrips();
	
}
