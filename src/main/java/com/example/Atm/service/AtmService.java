package com.example.Atm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Atm.model.Atm;
import com.example.Atm.util.AtmUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class AtmService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	AtmUtil atmUtil;

	public List<Atm> atmList;

	public List<Atm> getAllAtmDetails() throws JsonMappingException, JsonProcessingException {

		String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);

		String parsedResponse = response.substring(6, response.length());

		List<Atm> atmList = atmUtil.getMappedAtm(parsedResponse);

		return atmList;

	}

	public List<Atm> getAtmByCity(String city) throws JsonMappingException, JsonProcessingException {

		atmList = getAllAtmDetails();

		List<Atm> atmByCity = atmList.stream().filter(a -> city.equals(a.getAddress().getCity()))
				.collect(Collectors.toList());

		return atmByCity;

	}

}
