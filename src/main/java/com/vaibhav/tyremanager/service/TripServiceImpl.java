package com.vaibhav.tyremanager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.tyremanager.models.BusInventory;
import com.vaibhav.tyremanager.models.Trip;
import com.vaibhav.tyremanager.models.TyreInventory;
import com.vaibhav.tyremanager.repository.IBusInventoryRepository;
import com.vaibhav.tyremanager.repository.ITripRepository;


@Transactional
@Service
public class TripServiceImpl implements TripService {
	
	@Autowired private ITripRepository tripRepository;
	@Autowired private IBusInventoryRepository busRepository;

	@Override
	public Trip addTrip(final Trip trip) {
		BusInventory bus = busRepository.findById(trip.getBus().getBusId()).get();
		for(TyreInventory tyre : bus.getTyres()) {
			tyre.setDistanceTravelled(tyre.getDistanceTravelled().add(trip.getDistance()));
			if(tyre.getDistanceTravelled().compareTo(tyre.getTyreBrand().getThreshold()) > 0) {
				tyre.setThresholdFlag("Y");
			}
		}
		trip.setBus(busRepository.saveAndFlush(bus));
		return tripRepository.saveAndFlush(trip);
	}

	@Override
	public Trip getTrip(final Integer tripId) {
		return tripRepository.findById(tripId).orElse(new Trip());
	}

	@Override
	public List<Trip> getAllTrips() {
		return tripRepository.findAll();
	}
}
