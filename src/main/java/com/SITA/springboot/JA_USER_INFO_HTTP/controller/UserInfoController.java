package com.SITA.springboot.JA_USER_INFO_HTTP.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SITA.springboot.JA_USER_INFO_HTTP.service.UserInfoService;
import com.SITA.springboot.JA_USER_INFO_HTTP.service.UserType;

@RestController
public class UserInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	@Autowired
	UserType userType;

	@Autowired
	UserInfoService userInfoService;

	public UserInfoController(UserType userType) {
		this.userType = userType;
	}

	@GetMapping("/userDetail")
	public ResponseEntity<Map<String, String>> userDetail(@RequestParam("user") String userName) {

		logger.info("Start of userDetail in User Info controller.");
		
		Map<String, String> user = userType.getUsers();
		Map<String, String> response = new HashMap<>();
		
		String status="";
		if (user.containsKey(userName)) {
			String workStation = user.get(userName);
			status = userInfoService.postToAnotherService(userName, workStation);
			logger.info(status);

			response.put("user", userName);
			response.put("workStation", workStation);
			response.put("status", "Success");
			response.put("message", "User exists in database and has access to given workstation.");
			logger.info("End of userDetail in User Info controller.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			logger.info("User not valid");
			response.put("message", "User not found.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

}
