package com.nikhil.truyum.controller;

import java.util.Date;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nikhil.truyum.dao.FavoriteDaoImpl;
import com.nikhil.truyum.dao.LoginValidtion;
import com.nikhil.truyum.dao.MovieDao;
import com.nikhil.truyum.dao.NoFavoriteException;
import com.nikhil.truyum.entity.MovieData;
import com.nikhil.truyum.entity.User;
import com.nikhil.truyum.service.MovieService;
import com.nikhil.truyum.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@SessionAttributes("uname")
public class MenuController {

	@Autowired
	MovieDao moviedao;

	@Autowired
	FavoriteDaoImpl favt;

	@Autowired
	MovieService movieService;
//	
	@Autowired
	UserService userService;

	@Autowired
	LoginValidtion login;

	@RequestMapping("/home")
	public String viewHome(ModelMap model) {
		List<MovieData> list = movieService.getMovieListAdmin();
		model.put("list", list);
		return "home";
	}

	@RequestMapping("/adminlist")
	public String viewAdmin(ModelMap model) {
		List<MovieData> list = movieService.getMovieListAdmin();
		model.put("list", list);
		return "movielistAdmin";
	}
	
@RequestMapping("/customerlist")
	public String viewCustomer(ModelMap model) {
		List<MovieData> list = movieService.getMovieListCustomer();
		model.put("list", list);
		return "movielistCustomer";
	}



	@CrossOrigin
	@GetMapping("/adminmovielist")
	@ResponseBody
	public List<MovieData> getAdminMovies() {
		List<MovieData> list = movieService.getMovieListAdmin();
		return list;
	}

	

	@CrossOrigin
	@GetMapping("/customermovielist")
	@ResponseBody
	public List<MovieData> getCustMovieListjson() {
		List<MovieData> list = movieService.getMovieListCustomer();
		return list;
	}

	@CrossOrigin
	@GetMapping("/getmovie/{id}")
	@ResponseBody
	public MovieData getMoviebyId(@PathVariable int id) {
		return movieService.get(id);

	}
	
	@CrossOrigin
	@PutMapping("/edit/{id}")
	public ResponseEntity<MovieData> editMovie(@PathVariable int id, @RequestBody MovieData movie) {
		MovieData editedMovie = movieService.save(movie);
		return new ResponseEntity<MovieData>(movie, HttpStatus.OK);
	}
	
	@PostMapping("/edit")
	public ResponseEntity<Void> updateMovie(@RequestBody MovieData movie) {
		MovieData createMovie = movieService.save(movie);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createMovie.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	
	
//	@RequestMapping(value = "/editmovie", method = RequestMethod.GET)
//	public String editMenuItem() {
//		return "editmovie";
//	}
//
//	@GetMapping("/edit/{id}")
//	public MovieData editMovieList(@PathVariable int id) {
//		return movieService.get(id);
//	}

	

//@RequestMapping(value="/editmovieSuccess",method=RequestMethod.POST)
//	public String editMenuSuccess() {
//		return "editmovieSuccess";
//	}
//	

//@RequestMapping(value="/editmovie",method=RequestMethod.POST)
//public String editMenuSuccess(ModelMap model,@RequestParam int id, @RequestParam String title, @RequestParam String gross, 
//		@RequestParam String Active,@RequestParam String genre,@RequestParam String Teaser ) {
//	MovieData res=movieService.get(id);
//	res.setBoxoffice(gross);
//	res.setActive(Active);
//	res.setGenre(genre);
//	res.setHasteaser(Teaser);
//	movieService.save(res);
//	return "redirect:/adminlist";
//}

	@RequestMapping(value = "/movielistAdmin", method = RequestMethod.GET)
	public String movieAdmin(ModelMap model) {
		List<MovieData> list = movieService.getMovieListAdmin();
		model.put("list", list);
		return "movielistAdmin";
	}

	@RequestMapping(value = "/movielistCustomer", method = RequestMethod.GET)
	public String viewCustomer1(ModelMap model) {
		List<MovieData> list = movieService.getMovieListCustomer();
		model.put("list", list);
		return "movielistCustomer";
	}

//
//@RequestMapping(value="/addfavt")
//public String addToFavt(ModelMap model,@RequestParam long movie_id) {
//	String name= (String) model.get("uname");
//	System.out.println(name);
//	int uid=login.userid;
//	String username=login.uname;
//	int us_id=login.getUserId("uname");
//	favt.addFavMovie(uid, movie_id);
//	List<MovieData> list = moviedao.getMovieListCustomer();
//	MovieData movieData = new MovieData();
//	for(MovieData  ele:list) {
//		if(ele.getId()==movie_id) {
//			movieData=ele;
//		}
//	}
//	
//	model.put("itemid",movie_id);
//	model.put("uname",username);
//	model.put("list", list);
//	
//	return "favtSuccess";
//}

	@RequestMapping(value ="/viewfavrt/{username}")
	@ResponseBody
	public List<MovieData> viewFavorites(@PathVariable String username){
		User user =userService.findByName(username);
		
		List<Integer> list = movieService.getAllFavMovies(user.getUser_id());
		List<MovieData> favtlist = new ArrayList<>();
		
		for (Integer ele : list) {
			List<MovieData> tlist = movieService.getMovieListCustomer();
			for (MovieData m : tlist) {
				if (m.getId() == ele) {
					favtlist.add(m);
				}
			}
		}
		return favtlist;
	}
//	
//	@DeleteMapping(value="/delete/{username}/{id}")
//	@ResponseBody
//	public ResponseEntity<MovieData> deleteFromFavt(@PathVariable String username, @PathVariable int id){
//		User user =userService.findByName(username);
//		MovieData movie = movieService.removeFavtMovie(user.getUser_id(), id);
//		return new ResponseEntity<MovieData>(movie, HttpStatus.OK);
//		
//	}
	
	@PostMapping(value="/addfavt/{username}")
	@ResponseBody
	public ResponseEntity<MovieData> addtoFavt(@PathVariable String username, @PathVariable int id){
		MovieData movie =movieService.get(id);
		
		movieService.addToFavorites(username, movie);
		return new ResponseEntity<MovieData>(movie,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/addfavt")
	public String addToFavt(ModelMap model, @RequestParam int movie_id) {
		String name = (String) model.get("uname");
		System.out.println(name);
		int uid = login.userid;
		User user = userService.get(uid);
		MovieData movie = movieService.get(movie_id);
		Set<MovieData> movieList = user.getMovieList();
		movieList.add(movie);
		movieService.save(movie);
		return "favtSuccess";
	}

	
	@RequestMapping("/viewfavt")
	public String viewCart(ModelMap model) throws NoFavoriteException {
		int uid = login.userid;
		List<Integer> list = movieService.getAllFavMovies(uid);
		List<MovieData> favtlist = new ArrayList<>();
		double tot = 0;
		for (Integer ele : list) {
			List<MovieData> tlist = movieService.getMovieListCustomer();
			for (MovieData m : tlist) {
				if (m.getId() == ele) {
					favtlist.add(m);
					tot++;
				}
			}
		}
		model.put("list", favtlist);
		model.put("total", tot);
		return "favorite";
	}

	
	
	
//@RequestMapping("/removeItem")
//public String removeFavt(ModelMap model,@RequestParam long movie_id) {
//	int uid=login.userid;
//	favt.removeMovie(uid, movie_id);
//	return "favorite";
//	
//}

	@RequestMapping("/removeItem")
	public String removeFavt(ModelMap model, @RequestParam int movie_id) {
		int uid = login.userid;
		User user = userService.get(uid);
		MovieData movie = movieService.get(movie_id);
		Set<MovieData> movieList = user.getMovieList();
		movieList.remove(movie);
		favt.removeMovie(uid, movie_id);
		return "favorite";

	}

	@RequestMapping("/logout")
	public String logout(SessionStatus stat) {
		stat.setComplete();
		return "redirect:/login";
	}
}
