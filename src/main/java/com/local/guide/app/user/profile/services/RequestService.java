package com.local.guide.app.user.profile.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.guide.app.user.profile.dao.RequestRepository;
import com.local.guide.app.user.profile.entities.Request;

@Service
public class RequestService {
	@Autowired
	RequestRepository requestRepository;

	public List<Request> getAllRequests() {
		return requestRepository.findAll();
	}

	public Request createRequest(Request request) {
		return requestRepository.save(request);
	}

	public Request updatRequest(int id, Map<String, String> valuesToUpdate) throws NoSuchElementException {
		valuesToUpdate.remove("id");
		Request reqToUpdate = requestRepository.findById(id).get();
		if (reqToUpdate != null) {
			Request updatedReq = (Request) reqToUpdate.updateValues(reqToUpdate, valuesToUpdate);
			requestRepository.save(updatedReq);
			return updatedReq;
		} else {
			throw new NoSuchElementException();
		}
	}

	public List<Request> findRequestsByStatusAndDates(LocalDate start_date, LocalDate end_date, String status) {
		return requestRepository.findRequestsByStatusAndDates(status, start_date, end_date);
	}

	public Request getRequestById(int id) {
		Request request = requestRepository.findById(id).get();
		if (request != null) {
			return request;
		} else {
			throw new NoSuchElementException();
		}
	}

	public boolean isExists(int id) {
		return requestRepository.existsById(id);
	}
}
