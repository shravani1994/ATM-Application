package com.example.Atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Atm.model.Atm;
import com.example.Atm.service.AtmService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class AtmController {

	@Autowired
	AtmService atmService;

	@GetMapping(value = "/get/allAtm", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Atm> getAllAtm() throws JsonMappingException, JsonProcessingException {

		return this.atmService.getAllAtmDetails();
	}

	@GetMapping(value = "/get/allAtmByCity", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Atm> getAtmByCity(@RequestParam String city) throws JsonMappingException, JsonProcessingException {

		return this.atmService.getAtmByCity(city);

	}
}
