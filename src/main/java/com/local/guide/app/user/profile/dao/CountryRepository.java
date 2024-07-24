package com.local.guide.app.user.profile.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.local.guide.app.user.profile.entities.Country;
import java.util.List;
@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	@Override
	public List<Country> findAll();
}
