package com.local.guide.app.user.profile.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.local.guide.app.user.profile.entities.Location;
import com.local.guide.app.user.profile.entities.LocationDto;
import com.local.guide.app.user.profile.entities.LocationPrimaryKey;
import com.local.guide.app.user.profile.entities.UserDto;

@Repository
public interface LocationRepository extends JpaRepository<Location, LocationPrimaryKey> {
	@Query(nativeQuery = true, value = "select location,location_id from location where state_id= :state_id and country_id= :country_id")
	public List<LocationDto> getLocationsByState(@Param(value = "state_id") Integer state_id,
			@Param(value = "country_id") Integer country_id);

	@Query(nativeQuery = true, value = "select first_name,last_name,mobile_no,email from user where address_id in "
			+ "(select address_id from address where state_id= :state_id and country_id = :country_id and city_id= :city_id)")
	public List<UserDto> getUsersByLocations(@Param(value = "city_id") Integer city_id,
			@Param(value = "country_id") Integer country_id, @Param(value = "state_id") Integer state_id);
}
