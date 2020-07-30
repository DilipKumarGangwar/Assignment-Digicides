package com.dilip.springrest.daoservices;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dilip.springrest.dto.Dealer;


public interface DealerDAOService {
	
	List<Dealer> findAllDealerNearBy(Double latitude, Double longitude);

}
