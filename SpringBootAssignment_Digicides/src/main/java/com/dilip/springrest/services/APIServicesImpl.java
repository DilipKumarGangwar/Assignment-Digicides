package com.dilip.springrest.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.dilip.springrest.dto.APIData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class APIServicesImpl implements APIServices{

	@Override
	public List<Double> getLatitudeandLongitudeFromPostcode(Long postcode) throws IOException, URISyntaxException {
		
	    List<Double> datalist = new ArrayList<Double>();
		
		RestTemplate restTemplate = new RestTemplate();
		final String urlString = "https://nominatim.openstreetmap.org/search.php?q=" + postcode + "&format=json";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		APIData [] response = objectMapper.readValue(restTemplate.getForObject(urlString, String.class), APIData[].class);
		
		
		datalist.add(response[0].getLat());
		datalist.add(response[0].getLon());
		
		
		
		return datalist;
	}

}
