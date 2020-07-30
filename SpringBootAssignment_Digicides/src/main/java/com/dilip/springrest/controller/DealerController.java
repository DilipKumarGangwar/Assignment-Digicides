package com.dilip.springrest.controller;

import java.io.IOException;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dilip.springrest.dto.Dealer;
import com.dilip.springrest.exchanges.GetDealersResponse;
import com.dilip.springrest.services.APIServices;
import com.dilip.springrest.services.DealershipServices;

@Controller
public class DealerController {

	
	@Autowired
	DealershipServices dealerServices;
	
	@Autowired
	APIServices apiServices;
	
	@GetMapping("/")     
	@ResponseBody
	public String home() {
		
		return "welcome";
	}
	
	
	//API - 1 
	// It adds the dealers details into the H2- database
	
	@PostMapping("/dealer")
	@ResponseBody
	public void addNewDealer(@RequestParam(value="name") String name,
			@RequestParam(value="address") String address,
			@RequestParam(value="postcode") Long postcode) throws IOException, URISyntaxException {
		
		List<Double> list= new ArrayList<>();
		
		Double latitude, longitude;
		
	 	list.addAll(apiServices.getLatitudeandLongitudeFromPostcode(postcode));		
	 	
	 	latitude = list.get(0);
	 	longitude = list.get(1);
			
		
		System.out.println(name + " " + address+" "+ postcode + " " + latitude + " " + longitude);
		Dealer dealer = new Dealer(name,address, postcode,latitude,longitude);
		dealerServices.addDealer(dealer);
		
		
		//return ResponseEntity.ok(dealer);
		
	}
	
	
	//API - 2 (a)
	// Given the postcode of the customer place, it returns the nearest dealer information
	@GetMapping("/dealer")
	@ResponseBody
	public GetDealersResponse showAllNeighbourDealersByPostcode(@RequestParam(value="postcode") Long postcode ) throws IOException, URISyntaxException {
		
		GetDealersResponse getDealersResponse;
		
		getDealersResponse = dealerServices.showNeighbourDealersByPostcode(postcode);
	
	    return getDealersResponse; 	
	}
	
	
	//API - 2 (b)
	// Given the latitude and longitude of the customer place, it returns the nearest dealer information
	
	@GetMapping("/dealers")
	@ResponseBody
	public GetDealersResponse showAllNeighbourDealersByLat_Lon(@RequestParam(value="lat") Double latitude,
			@RequestParam(value="lon") Double longitude) throws IOException, URISyntaxException {
		
		GetDealersResponse getDealersResponse;
		getDealersResponse = dealerServices.showNeighbourDealersByLat_Lon(latitude,longitude);
	
	    return getDealersResponse; 	
	}
	

}
