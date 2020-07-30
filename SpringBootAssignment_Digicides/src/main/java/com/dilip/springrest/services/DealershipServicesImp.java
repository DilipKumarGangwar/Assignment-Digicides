package com.dilip.springrest.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dilip.springrest.dao.DealerDAO;
import com.dilip.springrest.daoservices.DealerDAOService;
import com.dilip.springrest.dto.Dealer;
import com.dilip.springrest.exchanges.GetDealersResponse;

@Service
@Component
public class DealershipServicesImp implements DealershipServices {

	@Autowired
	DealerDAO dealerRepo;
	
	@Autowired
	DealerDAOService dealerDAOService;

	@Autowired
	APIServices apiServices;
	
	@Override
	public void addDealer(Dealer dealer) {
		
		System.out.println("ok"+ dealer.getName() + " " + dealer.getAddress()+" "+ dealer.getPostcode());
		
		dealerRepo.save(dealer);
		
	}

	@Override
	public GetDealersResponse showNeighbourDealersByPostcode(Long postcode) throws IOException, URISyntaxException {
		GetDealersResponse response = new GetDealersResponse();
		//List<Dealer> list =dealerRepo.findAllByPostcodes(postcode,radius); 
        List<Double> list= new ArrayList<>();
        List<Dealer> result = new ArrayList<>();
        
		Double latitude;
		Double longitude;
		
		//get Latitude and longitude from Postcode by API call
	 	list.addAll(apiServices.getLatitudeandLongitudeFromPostcode(postcode));		
	 	
	 	latitude = list.get(0);
	 	longitude = list.get(1);
	
	
	 	result.addAll(dealerDAOService.findAllDealerNearBy(latitude,longitude));
		
	 	response.setDealers(result);
		return response;
	}
	
	
	public GetDealersResponse showNeighbourDealersByLat_Lon(Double latitude,Double longitude) throws IOException, URISyntaxException {
		
		GetDealersResponse response = new GetDealersResponse();
		List<Dealer> result = new ArrayList<>();
		result.addAll(dealerDAOService.findAllDealerNearBy(latitude,longitude));
		
		
	    response.setDealers(result);
		
		return response;
	}

}
