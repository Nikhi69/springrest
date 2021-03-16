package com.nikhil.truyum.entity;

import java.util.List;



public class Favorite {
	private List<MovieData>movieList; 
	private int numoffavt;
	private int favt_cartid;
	
	
	public int getFavt_cartid() {
		return favt_cartid;
	}
	public void setFavt_cartid(int favt_cartid) {
		this.favt_cartid = favt_cartid;
	}
	public Favorite(List<MovieData> movieList, int numoffavt) {
		super();
		this.movieList = movieList;
		this.numoffavt = numoffavt;
	}
	public List<MovieData> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<MovieData> movieList) {
		this.movieList = movieList;
	}
	public int getNumoffavt() {
		return numoffavt;
	}
	public void setNumoffavt(int numoffavt) {
		this.numoffavt = numoffavt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + numoffavt;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorite other = (Favorite) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (numoffavt != other.numoffavt)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", numoffavt=" + numoffavt + "]";
	}

	}
