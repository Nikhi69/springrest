package com.nikhil.truyum.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nikhil.truyum.entity.User;

public class JwtUserDetails implements UserDetails {

	private static final long serialVersionUID = 5155720064139820502L;
	private User user;
//	private final Long id;
//	private final String username;
//	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetails(User user) {
		super();
		this.user = user;
		this.authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));

//		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(user.getRole()));
//
//		this.authorities = authorities;
	}

//
//	@JsonIgnore
//	public Long getId() {
//		return id;
//	}
//
//	@Override
//	public String getUsername() {
//		return username;
//	}
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUser_name();
	}

//	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

//	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

//	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

//	@JsonIgnore
//	@Override
//	public String getPassword() {
//		return password;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}