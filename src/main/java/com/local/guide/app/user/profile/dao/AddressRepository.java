package com.local.guide.app.user.profile.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.local.guide.app.user.profile.entities.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
