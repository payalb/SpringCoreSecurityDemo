package com.java;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class AuthenticationManagerImpl implements AuthenticationManager {

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String name=auth.getName();
		MyUserDetailsService us= new MyUserDetailsService();
		UserDetails user=us.loadUserByUsername(name);
		if(user!= null) {
			return new UsernamePasswordAuthenticationToken(name, auth.getCredentials(),auth.getAuthorities());
		}
		return null;
	}

}

class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		InMemoryUserDetailsManager mgr= new InMemoryUserDetailsManager();
		mgr.createUser(User.withUsername("payal").password("payal123").roles("ADMIN").build());
		UserDetails ud=mgr.loadUserByUsername(username);
		return ud;
	}
	
}