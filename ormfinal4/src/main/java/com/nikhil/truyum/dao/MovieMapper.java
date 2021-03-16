package com.nikhil.truyum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nikhil.truyum.entity.MovieData;


@Component
public class MovieMapper implements RowMapper<MovieData> {

	@Override
	public MovieData mapRow(ResultSet rs, int rowNum) throws SQLException {
		MovieData movie =new MovieData();
		movie.setId(rs.getInt(1));
		movie.setTitle(rs.getString(2));
		movie.setBoxoffice(rs.getString(3));
		movie.setActive(rs.getString(4));
		movie.setDateoflaunch(rs.getDate(5));
		movie.setGenre(rs.getString(6));
		movie.setHasteaser(rs.getString(7));
		return movie;
	}
}
