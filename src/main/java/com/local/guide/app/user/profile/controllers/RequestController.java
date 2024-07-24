package com.local.guide.app.user.profile.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.local.guide.app.user.profile.entities.Request;
import com.local.guide.app.user.profile.services.RequestService;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/requests")
public class RequestController {
	@Autowired
	RequestService requestService;

	@GetMapping
	public ResponseEntity<List<Request>> getListOfRequests() {
		List<Request> requests = requestService.getAllRequests();
		return ResponseEntity.ok(requests);
	}

	@PostMapping
	public ResponseEntity<Request> createRequest(@RequestBody Request request) {
		Request createdReq = requestService.createRequest(request);
		return ResponseEntity.ok(createdReq);
	}

	@GetMapping("/findByStatusAndDates")
	public ResponseEntity<List<Request>> getRequestsByStatusAndDates(@RequestParam(name = "status") String status,
			@RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
		List<Request> reqList = requestService.findRequestsByStatusAndDates(startDate, endDate, status);
		return ResponseEntity.ok(reqList);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Object> updateRequest(@PathVariable("id") int id,
			@RequestBody Map<String, String> updatedFields) {
		requestService.updatRequest(id, updatedFields);
		return ResponseEntity.ok("updated successfully");
	}

	@GetMapping("/id")
	public ResponseEntity<Request> getRequestDetails(@RequestParam(name = "id") int id) throws NoSuchElementException {
		Request request = requestService.getRequestById(id);
		return ResponseEntity.ok(request);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> noValuePresent() {
		return new ResponseEntity<Object>("Request with given ID doesn't exists", new HttpHeaders(),
				HttpStatus.NOT_FOUND);
	}

}
