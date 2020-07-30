package com.dilip.springrest.services;

import java.io.IOException;

import java.net.URISyntaxException;
import java.util.List;


public interface APIServices {
	
	 /**
	   
	   * @param postcode - postcode of the customer 
	   
	   * @return latitude and longitude corresponding to the postcode
	   */
	List<Double> getLatitudeandLongitudeFromPostcode(Long postcode) throws IOException, URISyntaxException;
	

}
