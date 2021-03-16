package com.nikhil.truyum.entity;

import java.util.Date;
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

import org.springframework.stereotype.Repository;

@Entity
@Table(name = "movies")

public class MovieData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int id;
	@Column(name = "title")
	private String title;
	
	@Column(name = "box_office")
	private String boxoffice;
	
	@Column(name = "active")
	private String active;
	
	@Column(name = "dateof_release")
	private Date dateoflaunch;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "hasteaser")
	private String hasteaser;
	
//	@ManyToMany
//	(mappedBy="movieList")
//	private Set<User>userList;
	
	

//	public Set<User> getUserList() {
//		return userList;
//	}
//
//	public void setUserList(Set<User> userList) {
//		this.userList = userList;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoxoffice() {
		return boxoffice;
	}

	public void setBoxoffice(String boxoffice) {
		this.boxoffice = boxoffice;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getDateoflaunch() {
		return dateoflaunch;
	}

	public void setDateoflaunch(Date dateoflaunch) {
		this.dateoflaunch = dateoflaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getHasteaser() {
		return hasteaser;
	}

	public void setHasteaser(String hasteaser) {
		this.hasteaser = hasteaser;
	}

	
	public MovieData() {
		super();
	}

	public MovieData(int id, String title, String boxoffice, String active, Date dateoflaunch, String genre,
			String hasteaser, Set<User> userList) {
		super();
		this.id = id;
		this.title = title;
		this.boxoffice = boxoffice;
		this.active = active;
		this.dateoflaunch = dateoflaunch;
		this.genre = genre;
		this.hasteaser = hasteaser;
//		this.userList = userList;
	}



}
