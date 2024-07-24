package com.local.guide.app.user.profile.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.guide.app.user.profile.entities.Address;
import com.local.guide.app.user.profile.services.AddressService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;

	@PutMapping
	public ResponseEntity<Address> updateAddress(
			@RequestBody Address address) throws NoSuchElementException {
		Address updatedAddress = addressService.updateAddress(address);
		return ResponseEntity.ok(updatedAddress);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> noValuePresent() {
		return new ResponseEntity<Object>("address with given id not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
