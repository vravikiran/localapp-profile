package com.local.guide.app.user.profile.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.local.guide.app.user.profile.entities.State;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StateRepostiory extends CrudRepository<State, Integer> {
	@Query(value = "select state from State state where state.country_id= :country_id")
	public List<State> getStatesByCountry(@Param(value = "country_id") Integer country_id);
}
