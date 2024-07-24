package com.local.guide.app.user.profile.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.guide.app.user.profile.entities.AuthRequest;
import com.local.guide.app.user.profile.entities.User;
import com.local.guide.app.user.profile.exceptions.AuthFailException;
import com.local.guide.app.user.profile.services.OtpService;
import com.local.guide.app.user.profile.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	private OtpService otpService;
	@Autowired
	UserService userService;

	@GetMapping(value = "/generateOtp")
	public ResponseEntity<Object> generateOtp(@RequestParam String mobileNo) {
		String otp = otpService.generateOtp(mobileNo);
		System.out.println("OTP::" + otp);
		return ResponseEntity.ok(otp);
	}

	@PostMapping("/validateOtp")
	public ResponseEntity<User> validateOtp(@RequestBody AuthRequest authRequest)
			throws NoSuchElementException, AuthFailException, Exception {
		if (userService.findUserById(Long.valueOf(authRequest.getMobileNo())) != null
				&& otpService.validateOtp(authRequest)) {
			User user = userService.findUserById(Long.valueOf(authRequest.getMobileNo()));
			return ResponseEntity.ok(user);
		} else
			throw new AuthFailException();

	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleInvalidNumber() {
		return new ResponseEntity<Object>("Account doesn't exists with given mobile number", new HttpHeaders(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AuthFailException.class)
	public ResponseEntity<Object> handleInvalidOtp() {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Entered OTP is invalid");
	}
}
