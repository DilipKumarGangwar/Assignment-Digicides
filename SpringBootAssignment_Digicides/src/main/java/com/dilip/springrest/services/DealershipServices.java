package com.dilip.springrest.services;

import java.io.IOException;

import java.net.URISyntaxException;
import com.dilip.springrest.dto.Dealer;
import com.dilip.springrest.exchanges.GetDealersResponse;

public interface DealershipServices {
	
	 /**
	   * @param dealer - the dealer object / info to be added in the database
	   * @return nothing
	   */ 
	public void addDealer(Dealer dealer);	
	
	 /**
	   * @param postcode - the postcode of the location near which you want to find any dealer
	   * @return the nearest dealer info as response object
	   */ 
	
	public GetDealersResponse showNeighbourDealersByPostcode(Long postcode) throws IOException, URISyntaxException;
	
	/**
	   * @param latitude - the coordinate of the location near which you want to find any dealer
	   * @param longitude - the coordinate of the location near which you want to find any dealer
	   * @return the nearest dealer info as response object
	   */ 
	public GetDealersResponse showNeighbourDealersByLat_Lon(Double latitude,Double longitude) throws IOException, URISyntaxException;
	
	

}
