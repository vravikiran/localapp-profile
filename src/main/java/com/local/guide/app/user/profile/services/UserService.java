package com.local.guide.app.user.profile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.guide.app.user.profile.dao.UserRepository;
import com.local.guide.app.user.profile.entities.Address;
import com.local.guide.app.user.profile.entities.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		Address updatedAddress = user.getAddress();
		user.setAddress(updatedAddress);
		return userRepository.save(user);
	}

	 public User updateUser(User user) throws Exception {
		return userRepository.save(user);
	}

	public User getUser(long mobileNo) {
		return userRepository.findById(mobileNo).get();
	}

	public boolean deleteUser(long mobileNo) throws Exception {
		boolean isUserDeleted = true;
		if (userRepository.findById(mobileNo) != null) {
			userRepository.deleteById(mobileNo);
		} else {
			isUserDeleted = false;
			throw new Exception("user not found");
		}
		return isUserDeleted;
	}

	public User findUserById(long mobileNo) throws Exception {
		if (userRepository.findById(mobileNo) != null) {
			return userRepository.findById(mobileNo).get();
		} else {
			throw new Exception("user not found");
		}
	}
}
