package com.nikhil.truyum.dao;

import java.util.List;

import com.nikhil.truyum.entity.MovieData;




public interface FavoriteDao {
	public void addFavMovie(long userId, long movieId);

	public List<Integer> getAllFavMovies(long userID) throws NoFavoriteException;

	public void removeMovie(long userId, long movieId);
}
