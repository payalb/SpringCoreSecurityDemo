package com.java;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationSample {

	static AuthenticationManager mgr= new AuthenticationManagerImpl();
	public static void main(String args[]) {
		String username="payal";
		String password="payal123";
		Authentication auth=new UsernamePasswordAuthenticationToken(username, password);
		Authentication authenticated=mgr.authenticate(auth);
		SecurityContextHolder.getContext().setAuthentication(authenticated);
		
	}
}
