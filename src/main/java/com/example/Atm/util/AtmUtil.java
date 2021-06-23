package com.example.Atm.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Atm.model.Atm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AtmUtil {
	
	public List<Atm> getMappedAtm(String parsedResponse) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Atm[] atm = mapper.readValue(parsedResponse, Atm[].class);
		return Arrays.asList(atm);
	}

}
