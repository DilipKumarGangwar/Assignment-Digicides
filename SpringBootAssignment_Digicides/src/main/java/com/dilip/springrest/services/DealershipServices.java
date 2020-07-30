package com.dilip.springrest.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.dilip.springrest.dto.Dealer;
import com.dilip.springrest.exchanges.GetDealersResponse;

public interface DealershipServices {
	

	public void addDealer(Dealer dealer);	
	public GetDealersResponse showNeighbourDealersByPostcode(Long postcode) throws IOException, URISyntaxException;
	public GetDealersResponse showNeighbourDealersByLat_Lon(Double latitude,Double longitude) throws IOException, URISyntaxException;
	
	

}
