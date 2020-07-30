package com.dilip.springrest.services;

import java.io.IOException;

import java.net.URISyntaxException;
import java.util.List;

import com.dilip.springrest.dto.APIData;


public interface APIServices {
	
	
	List<Double> getLatitudeandLongitudeFromPostcode(Long postcode) throws IOException, URISyntaxException;
	

}
