package com.dilip.springrest.controller;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dilip.springrest.services.APIServices;
import com.dilip.springrest.services.DealershipServices;

@RunWith(JUnitPlatform.class)
class DealerControllerTest {

	
	
	@InjectMocks
	private DealerController dealerController;
	
	@MockBean
	private DealershipServices dealerServices;
	
	@MockBean
	APIServices apiServices;
	
	
	 @BeforeEach
	  public void setup() {
	   MockitoAnnotations.initMocks(this);

	   MockMvcBuilders.standaloneSetup(dealerController).build();
	  }
	 
	@Test
	void ValidateTest() throws IOException, URISyntaxException {
		
	    dealerController.showAllNeighbourDealersByPostcode(anyLong());
		
		verify(dealerController).showAllNeighbourDealersByPostcode(anyLong());
		
		
	}

}
