package com.local.guide.app.user.profile.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.guide.app.user.profile.dao.AddressRepository;
import com.local.guide.app.user.profile.entities.Address;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	public Address updateAddress(Address address) throws NoSuchElementException {
		if(addressRepository.findById(address.getAddress_id()) != null) {
			return addressRepository.save(address);
		} else {
			throw new NoSuchElementException();
		}
	}
}
