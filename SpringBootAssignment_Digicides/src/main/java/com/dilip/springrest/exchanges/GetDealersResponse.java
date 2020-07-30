package com.dilip.springrest.exchanges;

import java.util.List;


import com.dilip.springrest.dto.Dealer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDealersResponse {
	
	List<Dealer> dealers;

	public GetDealersResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public GetDealersResponse(List<Dealer> dealers) {
		super();
		this.dealers = dealers;
	}


	public List<Dealer> getDealers() {
		return dealers;
	}

	public void setDealers(List<Dealer> dealers) {
		this.dealers = dealers;
	}


	@Override
	public String toString() {
		return "GetDealersResponse [dealers=" + dealers + "]";
	}
	

}
