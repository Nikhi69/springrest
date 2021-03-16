package com.nikhil.truyum.dao;

import java.util.List;

import com.nikhil.truyum.entity.MovieData;



public interface MovieDao {
	List<MovieData> getMovieListAdmin();

	List<MovieData> getMovieListCustomer();

	void modifyMovie(MovieData moviedata);

	MovieData getMovie(long movieId);
}
