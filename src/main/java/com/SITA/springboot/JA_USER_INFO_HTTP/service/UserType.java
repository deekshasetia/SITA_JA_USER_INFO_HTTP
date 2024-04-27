package com.SITA.springboot.JA_USER_INFO_HTTP.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserType {
	private UserProperties userProperties;

	@Autowired
	public UserType(UserProperties userProperties) {
		this.userProperties = userProperties;
	}

	public Map<String, String> getUsers() {
		return userProperties.getType();
	}


}
