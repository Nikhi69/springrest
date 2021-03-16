package com.nikhil.truyum.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class FavoriteDaoImpl implements FavoriteDao {

	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	FavoriteMapper fmapper;
	@Override
	public void addFavMovie(long userId, long movieId) {
		String sql= "insert into favorite(favt_userid,favt_movieid) values(?,?)";
		int result =jdbc.update(sql,userId,movieId);
	}

	@Override
	public List<Integer> getAllFavMovies(long userID) throws NoFavoriteException {
		String sql ="select favt_movieid from favorite where favt_userid=?";
		List<Integer> list = jdbc.query(sql, fmapper,userID);
		
		return list;
	}

	@Override
	public void removeMovie(long userId, long movieId) {
		 String sql="delete from favorite where favt_userid=? and favt_movieid=?";
		  jdbc.update(sql,userId,movieId);
	}

}
