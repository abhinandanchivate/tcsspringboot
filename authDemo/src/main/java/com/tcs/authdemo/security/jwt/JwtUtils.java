package com.tcs.authdemo.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

	
	public String generateJwtToken(Authentication authentication) {
		// userName
		
		authentication.getPrincipal();
		// do we need to build token?
		/// do we need current time to provide IAT?
		// do we need exp time?
		// alog for generating token
		// compress/compact the token
	}
	public String getUserNameFromJwtToken(String token) {
		
	}
	
	
	public boolean validateJwtToken(String authToken) {
		
	}
}
