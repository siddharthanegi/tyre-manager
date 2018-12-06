package com.vaibhav.tyremanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaibhav.tyremanager.models.BusProvider;
import com.vaibhav.tyremanager.models.PurchaseOrder;
import com.vaibhav.tyremanager.models.Trip;
import com.vaibhav.tyremanager.models.TyreBrand;
import com.vaibhav.tyremanager.repository.IBusInventoryRepository;
import com.vaibhav.tyremanager.repository.IBusProviderRepository;
import com.vaibhav.tyremanager.repository.IPurchaseOrderRepository;
import com.vaibhav.tyremanager.repository.ITyreBrandRepository;
import com.vaibhav.tyremanager.service.TripService;
import com.vaibhav.tyremanager.service.TyreService;

@Controller
public class AppController {
	
	@Autowired private IBusProviderRepository busProviderRepository;
	@Autowired private TripService tripService;
	@Autowired private IBusInventoryRepository busRepository;
	@Autowired private ITyreBrandRepository tyreBrandRepository;
	@Autowired private IPurchaseOrderRepository purchaseOrderRepository;
	@Autowired private TyreService tyreService;
	
	@RequestMapping(value = {"/","/home"})
	private String home() {
		return "home";
	}
	
	@GetMapping("/tripdashboard")
	private String tripDashboard(Model model) {
		model.addAttribute("trips", tripService.getAllTrips());
		return "trip_dash";
	}
	
	@GetMapping("/providerdashboard")
	private String providerDashboard(Model model) {
		model.addAttribute("providers", busProviderRepository.findAll());
		return "provider_dash";
	}
	
	@GetMapping("/addtrip")
	private String addTripView(Model model) {
		model.addAttribute("buses", busRepository.findAll());
		model.addAttribute("newTrip", new Trip());
		return "add_trip";
	}
	
	@GetMapping("/tyredashboard")
	private String tyreDashboard(Model model) {
		List<TyreBrand> brands = tyreBrandRepository.findAll();
		model.addAttribute("brands", brands);
		return "tyre_dash";
	}
	
	
	@GetMapping("/newpurchaseorder")
	private String purchaseOrder(Model model) {
		model.addAttribute("brands", tyreBrandRepository.findAll());
		model.addAttribute("purchaseOrder", new PurchaseOrder());
		return "purchase_order";
	}
	
	@GetMapping(path="/providers")
	@ResponseBody private List<BusProvider> fetchAllProviders(){
		return busProviderRepository.findAll();
	}
	
	@GetMapping(path="/providers/{id}")
	@ResponseBody private BusProvider fetchProvider(@PathVariable Integer id){
		return busProviderRepository.findById(id).orElse(new BusProvider());
	}
	
	@PostMapping(path="/providers")
	@ResponseBody private BusProvider addOrUpdateProvider(@RequestBody BusProvider busProvider) {
		return busProviderRepository.save(busProvider);
	}

	@PostMapping(path="/trips")
	private String addTrip(@ModelAttribute("newtrip") Trip trip, Model model){
		Trip tripDb = tripService.addTrip(trip);
		StringBuilder builder = null;
		if(tripDb.getBus().getTyres().stream().anyMatch(t -> "Y".equalsIgnoreCase(t.getThresholdFlag()))) {
			builder = new StringBuilder();
			builder.append("Note : Threshold for the following tyre(s) reached :");
			builder.append(tripDb.getBus().getTyres().stream().filter(t -> "Y".equalsIgnoreCase(t.getThresholdFlag()))
					.map(t -> String.valueOf(t.getTyreId())).collect(Collectors.joining(",")));
		}
		model.addAttribute("message","Trip ID "+tripDb.getTripId()+" added successfully");
		if(null != builder) {
			model.addAttribute("thresholdMessage",builder.toString());			
		}
		return "success";
	}
	
	@GetMapping(path="/trips/{id}")
	@ResponseBody private Trip getTrip(@PathVariable Integer id){
		return tripService.getTrip(id);
	}
	
	@PostMapping(path="/purchaseorders")
	private String addPurchase(@ModelAttribute("purchaseOrder") PurchaseOrder order, Model model){
		PurchaseOrder orderDb = purchaseOrderRepository.save(order);
		model.addAttribute("message","Purchase order ID "+orderDb.getId()+" placed successfully");
		return "success";
	}
	
	@GetMapping(path="/purchaseorders")
	private String purchaseOrderView(Model model){
		model.addAttribute("orders", purchaseOrderRepository.findAll());
		return "order_book";
	}
	
	@GetMapping(path="/wornout")
	private String wornOutTyres(Model model){
		model.addAttribute("tyres", tyreService.wornOutTyres());
		return "worn_tyres";
	}

}
