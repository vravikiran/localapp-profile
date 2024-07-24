package com.local.guide.app.user.profile.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.local.guide.app.user.profile.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	@Query(value="select loc from Location loc where loc.state_id= :state_id ")
	public List<Location> getLocationsByState(@Param(value ="state_id") Integer state_id);
}
