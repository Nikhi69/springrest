package com.nikhil.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.nikhil.truyum.entity.MovieData;
@Repository
public class MovieDaoImpl implements MovieDao {
	@Autowired
	MovieMapper mapper;
	
	@Autowired
	JdbcTemplate jdbc;
	
	
	@Override
	public List<MovieData> getMovieListAdmin() {
		String sql = "select * from movies";
		List<MovieData> list = jdbc.query(sql, mapper);
		return list;
	}

	@Override
	public List<MovieData> getMovieListCustomer() {
		List<MovieData> customerList = new ArrayList<>();

		String sql = "select * from movies";
		List<MovieData> list = jdbc.query(sql, mapper);
		for (MovieData ele : list) {
			if (ele.getActive().equalsIgnoreCase("Yes") && ele.getDateoflaunch().before(new Date())) {
				customerList.add(ele);
			}
		}
		return customerList;
	}

	@Override
	public void modifyMovie(MovieData moviedata) {

	}

	@Override
	public MovieData getMovie(long movieId) {
		return null;
	}

}
