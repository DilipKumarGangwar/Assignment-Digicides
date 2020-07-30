package com.dilip.springrest.daoservices;

import java.util.List;


import com.dilip.springrest.dto.Dealer;


public interface DealerDAOService {
	
	 /**
	   * @param latitude coordinates near which we have to search for dealer
	   * @param longitude coordinates near which we have to search for dealer
	  
	   * @return nearest dealer information or empty list if there is none
	   */
	List<Dealer> findAllDealerNearBy(Double latitude, Double longitude);

}
