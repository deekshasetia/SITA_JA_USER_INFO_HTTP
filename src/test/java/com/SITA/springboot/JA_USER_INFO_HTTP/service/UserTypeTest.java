package com.SITA.springboot.JA_USER_INFO_HTTP.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserTypeTest {
	
	@InjectMocks
	UserType userType;
	
	@Mock
	UserProperties userProperties;
	
	@Test
	public void testUserType() {
		
		Map<String, String> type = new HashMap<>();
		type.put("validUser", "C11FGIG01");
		type.put("admin", "CCUICKB0F1");
		Mockito.lenient().when(userProperties.getType()).thenReturn(type);

		Map<String, String> result = userType.getUsers();
		assertEquals("C11FGIG01", result.get("validUser"));
		assertEquals("CCUICKB0F1", result.get("admin"));
	}

}
