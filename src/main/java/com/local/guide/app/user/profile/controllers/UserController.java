package com.local.guide.app.user.profile.controllers;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.local.guide.app.user.profile.entities.User;
import com.local.guide.app.user.profile.entities.UserDto;
import com.local.guide.app.user.profile.services.FileService;
import com.local.guide.app.user.profile.services.UserService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	FileService fileService;

	@GetMapping("/getProfile")
	public ResponseEntity<User> getUserDetails(@RequestParam("mobileNo") String mobileNo)
			throws NumberFormatException, Exception {
		User user = userService.findUserById(Long.valueOf(mobileNo));
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return ResponseEntity.ok(createdUser);
	}

	@PatchMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
		User updateduser = userService.updateUser(user);
		return ResponseEntity.ok(updateduser);
	}

	@DeleteMapping("/{mobileNo}")
	public void deleteUsr(@PathVariable long mobileNo) throws Exception {
		userService.deleteUser(mobileNo);
	}

	@PostMapping(path = "/upload", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Object> upload(@RequestBody String file) throws IOException {
		if (file != null) {
			fileService.imageUploadForWeb(file);
		} else {
			System.out.println("file empty");
		}
		return ResponseEntity.ok("success");
	}

	@PostMapping(path = "/uploadFromMobile")
	public ResponseEntity<Object> uploadImageForMobile(@RequestParam("photo") MultipartFile file) throws IOException {
		fileService.imageUploadFromMobile(file);
		return ResponseEntity.ok("success");
	}

	@GetMapping(path = "/location")
	public ResponseEntity<List<UserDto>> getUsersByLocation(@RequestParam("city_id") int city_id, @RequestParam("country_id") int country_id,@RequestParam("state_id") int state_id) {
		List<UserDto> userDtos = userService.fetchUsersByLocation(city_id,country_id,state_id);
		return ResponseEntity.ok(userDtos);
	}

	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> handleIOException() {
		return ResponseEntity.status(HttpStatus.SC_FORBIDDEN).build();
	}

}
