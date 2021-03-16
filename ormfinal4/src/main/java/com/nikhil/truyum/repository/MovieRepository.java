package com.nikhil.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nikhil.truyum.entity.MovieData;

public interface MovieRepository extends JpaRepository<MovieData, Integer> {
//	@Query(value = " FROM MovieData ")
//	List<MovieData> getMovieListAdmin();
//	
//	@Query(value = " FROM MovieData ")
//	List<MovieData> getMovieListCustomer();
	
//	@Query(value="Select m FROM MovieData m left join fetch m.userList WHERE m.user.id=:userID ")
//	public List<Integer> getAllFavMovies(@Param("userID") int userID);
	
	@Query(value = "select favt_movieid from favorite where favt_userid=?", nativeQuery = true)
	public List<Integer> getAllFavMovies(@Param("userID") int userID);
	
	@Query(value ="insert into favorite(favt_userid,favt_movieid) values(?,?)", nativeQuery = true)
	public void addFavMovie(long userId, long movieId);

	

//	public MovieData findByName(String title);

}
