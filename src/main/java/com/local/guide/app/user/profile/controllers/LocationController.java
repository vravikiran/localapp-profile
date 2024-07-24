package com.local.guide.app.user.profile.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.guide.app.user.profile.entities.Country;
import com.local.guide.app.user.profile.entities.Location;
import com.local.guide.app.user.profile.entities.State;
import com.local.guide.app.user.profile.services.LocationService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/locations")
public class LocationController {
	@Autowired
	LocationService locationService;

	@GetMapping("/state")
	public ResponseEntity<List<Location>> getLocationsByState(@RequestParam(name = "state_id") Integer state_id) {
		List<Location> countries = locationService.getLocationsByState(state_id);
		return ResponseEntity.ok(countries);
	}

	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getListOfCountries() {
		List<Country> countries = locationService.getCountries();
		return ResponseEntity.ok(countries);
	}

	@GetMapping("/statesByCountry")
	public ResponseEntity<List<State>> getStatesByCountry(@RequestParam(name = "country_id") Integer country_id) {
		List<State> states = locationService.getStatesByCountry(country_id);
		return ResponseEntity.ok(states);
	}
}
