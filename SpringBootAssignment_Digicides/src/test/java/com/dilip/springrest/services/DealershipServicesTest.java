package com.dilip.springrest.services;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dilip.springrest.SpringBootAssignmentDigicidesApplication;
import com.dilip.springrest.daoservices.DealerDAOService;
import com.dilip.springrest.dto.Dealer;
import com.dilip.springrest.exchanges.GetDealersResponse;

@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = {SpringBootAssignmentDigicidesApplication.class})
class DealershipServicesTest {

	@InjectMocks
	private  DealershipServicesImp dealershipServices;
	
	@MockBean
	private DealerDAOService dealerDAOService;
	
	@MockBean
	APIServices apiServices;
	
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	
    @Test
	public GetDealersResponse testshowNeighbourDealersByLat_Lon( Double latitude, Double longitude) throws IOException, URISyntaxException {
		
		
		List <Dealer> dealers = new ArrayList<>();
		when(dealerDAOService.findAllDealerNearBy(anyDouble(), anyDouble())).thenReturn(dealers);
		
		GetDealersResponse response = dealershipServices.showNeighbourDealersByLat_Lon(17.4849897, 78.37822645302441);
		
		assertEquals(1 , response.getDealers().size());   //as the only one nearest dealer should be returned
		
		verify(dealerDAOService,times(1)).findAllDealerNearBy(anyDouble(),anyDouble());
		
		return response;
		
		
		
	}
    
    
    @Test
   	public GetDealersResponse testshowNeighbourDealersByPostcode( Long postcode) throws IOException, URISyntaxException {
   		
   		
   		List <Dealer> dealers = new ArrayList<>();
   	    
   		
   		
   		when(apiServices.getLatitudeandLongitudeFromPostcode(anyLong()));
   		when(dealerDAOService.findAllDealerNearBy(anyDouble(), anyDouble())).thenReturn(dealers);
   		
   		GetDealersResponse response = dealershipServices.showNeighbourDealersByPostcode(500081L);
   		
   		assertEquals(1 , response.getDealers().size());   //as the only one nearest dealer should be returned
   		
   		verify(apiServices,times(1)).getLatitudeandLongitudeFromPostcode(anyLong());
   		verify(dealerDAOService,times(1)).findAllDealerNearBy(anyDouble(),anyDouble());
   		
   		return response;
   		
   		
   		
   	}
	
	
	

}
