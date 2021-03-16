package com.nikhil.truyum.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.truyum.entity.MovieData;
import com.nikhil.truyum.entity.User;
import com.nikhil.truyum.repository.MovieRepository;
import com.nikhil.truyum.repository.UserRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public MovieData get(int id) {
		return movieRepository.findById(id).get();
	}

	@Transactional
	public MovieData save(MovieData movie) {
		return movieRepository.save(movie);
	}
	

	@Transactional
	public List<MovieData> getMovieListAdmin(){
		return movieRepository.findAll();
	}
	
	@Transactional
	public List<MovieData> getMovieListCustomer(){
		List<MovieData> movieListCustomer = new ArrayList<>();
		List<MovieData> list = movieRepository.findAll();
		for (MovieData ele : list) {
			if (ele.getActive().equalsIgnoreCase("Yes") && ele.getDateoflaunch().before(new Date())) {
				movieListCustomer.add(ele);
			}
		}
		return movieListCustomer;
		
	}
	
	@Transactional
	public List<Integer> getAllFavMovies(int userID){
		return movieRepository.getAllFavMovies(userID);
	}
	
	
	@Transactional
	public MovieData addToFavorites(String username, MovieData movie) {
		User user = userRepository.findByUsername(username);
		Set<MovieData> favorites =user.getMovieList();
		favorites.add(movie);
		user.setMovieList(favorites);
		userRepository.save(user);
		return movie;
	}
	
//	@Transactional
//	public void addFavMovie(long userId, long movieId) {
//		movieRepository.addFavMovie(userId,movieId);
//	}
	
}
