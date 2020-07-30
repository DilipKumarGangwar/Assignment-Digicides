package com.dilip.springrest.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dilip.springrest.dto.APIData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class APIServicesImpl implements APIServices{

	@Override
	public List<Double> getLatitudeandLongitudeFromPostcode(Long postcode) throws IOException, URISyntaxException {
		
		//This stores the latitude and longitude to be returned 
	    List<Double> datalist = new ArrayList<Double>();
		
		RestTemplate restTemplate = new RestTemplate();
		
		//construct the URL
		final String urlString = "https://nominatim.openstreetmap.org/search.php?q=" + postcode + "&format=json";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Get the latitude and longitude
		APIData [] response = objectMapper.readValue(restTemplate.getForObject(urlString, String.class), APIData[].class);
		
		
		datalist.add(response[0].getLat());
		datalist.add(response[0].getLon());
		
		
		//return the list 
		return datalist;
	}

}
