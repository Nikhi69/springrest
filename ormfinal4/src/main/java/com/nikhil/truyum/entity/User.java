package com.nikhil.truyum.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "user_name")
	private String username;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name ="favorite",joinColumns = @JoinColumn(name ="favt_userid"),
			inverseJoinColumns = @JoinColumn(name ="favt_movieid"))
	private Set<MovieData> movieList;

	
	public User() {
		super();
	}

	public User(int user_id, String user_name, String firstname, String lastname, String password, String role,
			Set<MovieData> movieList) {
		super();
		this.user_id = user_id;
		this.username = user_name;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.role = role;
		this.movieList = movieList;
	}

	

	public Set<MovieData> getMovieList() {
		return movieList;
	}

	public void setMovieList(Set<MovieData> movieList) {
		this.movieList = movieList;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return username;
	}

	public void setUser_name(String user_name) {
		this.username = user_name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUser_id(String name) {
		return user_id;
	}

}
