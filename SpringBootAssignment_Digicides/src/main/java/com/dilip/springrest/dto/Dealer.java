package com.dilip.springrest.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Dealer {
	
	@Id
	private String name;
	private String address;
	private Long postcode;
	private Double latitude;
	private Double longitude;

	public Dealer() {
		super();
	
	}
	
	

	public Dealer(String name, String address, Long postcode, Double latitude, Double longitude) {
		super();
		this.name = name;
		this.address = address;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPostcode() {
		return postcode;
	}
	public void setPostcode(Long postcode) {
		this.postcode = postcode;
	}
	
	
    
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Dealer [name=" + name + ", address=" + address + ", postcode=" + postcode + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

	
}
