package com.local.guide.app.user.profile.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.local.guide.app.user.profile.entities.Request;
import java.time.LocalDate;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
	@Query(value = "select req from Request req where (:status is null or req.status = :status) and (:start_date is null or req.start_date= :start_date) and (:end_date is null or end_date= :end_date)")
	public List<Request> findRequestsByStatusAndDates(
			@Param(value = "status") String status,
			@Param(value = "start_date") LocalDate start_date,
			@Param(value="end_date") LocalDate end_date
			);
}
