package com.dilip.springrest.dto;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class DealerTest {

	@Test
	void serializeAndDeserializeJSON() throws JsonMappingException, JsonProcessingException, JSONException {


		final String expectedString =
			"{\n"
					
					+ "    \"name\": \"Dilip\",\n"
		            + "    \"address\" : \"Hitech\",\n"
		            + "    \"postcode\": 500082,\n"
		            + "    \"latitude\": 20.027,\n"
		            + "    \"longitude\": 30.0\n"
	                + "}";  
		         
		            
		      
		
		
		Dealer dealer = new Dealer();
		
		//serialize the object
		ObjectMapper objectMapper = new ObjectMapper();
		
		dealer = objectMapper.readValue(expectedString, Dealer.class);
		
		//deserialize the object		
		String actualString ="";

		actualString = new ObjectMapper().writeValueAsString(dealer);
		
		JSONAssert.assertEquals(expectedString, actualString, true);
		
		
	}

}
