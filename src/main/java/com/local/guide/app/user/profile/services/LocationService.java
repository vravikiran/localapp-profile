package com.local.guide.app.user.profile.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.guide.app.user.profile.dao.CountryRepository;
import com.local.guide.app.user.profile.dao.LocationRepository;
import com.local.guide.app.user.profile.dao.StateRepostiory;
import com.local.guide.app.user.profile.entities.Country;
import com.local.guide.app.user.profile.entities.LocationDto;
import com.local.guide.app.user.profile.entities.State;

@Service
public class LocationService {
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	StateRepostiory stateRepostiory;

	public List<LocationDto> getLocationsByState(Integer state_id,Integer country_id) {
		return locationRepository.getLocationsByState(state_id,country_id);
	}

	public List<Country> getCountries() {
		return countryRepository.findAll();
	}

	public List<State> getStatesByCountry(Integer country_id) {
		return stateRepostiory.getStatesByCountry(country_id);
	}
}
