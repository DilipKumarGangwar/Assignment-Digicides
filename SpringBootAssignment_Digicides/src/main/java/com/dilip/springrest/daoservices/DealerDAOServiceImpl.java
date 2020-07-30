package com.dilip.springrest.daoservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dilip.springrest.dao.DealerDAO;
import com.dilip.springrest.dto.Dealer;

@Component
public class DealerDAOServiceImpl implements DealerDAOService {

	@Autowired
	DealerDAO dealerRepo;
	
	// Returns  the distance between 2 latitude, longitudes
	Double findDistance(Double latitude1,Double longitude2, Double latitude2, Double longitude1) {
		
		
	    double dlat = Math.toRadians(latitude2) - Math.toRadians(latitude1); 
	    double dlon = Math.toRadians(longitude1) - Math.toRadians(longitude1); 

	    

	    //applying the formula
	    double a = Math.pow(Math.sin(dlat / 2), 2)
	               + Math.pow(Math.sin(dlon / 2), 2)
	               * Math.cos(latitude1)   
	               * Math.cos(latitude2); 
	    double rad = 6371; 
	    double c = 2 * Math.asin(Math.sqrt(a)); 
	    System.out.println("Distancde= " + rad*c);
	    return (Double) rad * c;  
		
		
	}
	
	 
	@Override
	public List<Dealer> findAllDealerNearBy(Double latitude, Double longitude) {
	    
		List<Dealer> result = new ArrayList<>();
		List<Dealer> dealerlist = new ArrayList<>();
		
		
		//load all dealers from in-memory database
		
		dealerlist = dealerRepo.findAll();
		
		Double olddistance =findDistance(latitude,longitude, dealerlist.get(0).getLatitude(),dealerlist.get(0).getLongitude());
		Double newdistance =0.0;
		int nearest_dealer_index =0;
		
		
		//find the distance between customer and each dealer
		int len = dealerlist.size();
		for (int i=1;i<len;i++) {
			newdistance=findDistance(latitude,longitude, dealerlist.get(i).getLatitude(),dealerlist.get(i).getLongitude());
			
			if(newdistance< olddistance){
				System.out.println("newDistance is ="+newdistance);
				nearest_dealer_index=i;
				olddistance=newdistance;
				
			}
		}
		
		//add nearest dealer in result list
		result.add(dealerlist.get(nearest_dealer_index));
		
		//return the nearest dealer info
		return result;
	}

}
