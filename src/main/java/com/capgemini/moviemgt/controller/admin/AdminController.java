/**
 * Controller for Admin
 */
package com.capgemini.moviemgt.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviemgt.model.Movie;
import com.capgemini.moviemgt.model.Show;
import com.capgemini.moviemgt.model.Theater;
import com.capgemini.moviemgt.service.admin.AdminService;
/**
 * @author krishna
 *
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;


	/* Lists to store components temporarily */
	private List<Movie> moviesList;
	private List<Show> showList;
	
	/************ Theater Add and Delete Methods *******************/

	/* Method to add new theater */
	@RequestMapping(value = "/theater/addTheater", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Theater> addTheater(@RequestBody Theater theater) {
		return new ResponseEntity<Theater>(adminService.addTheater(theater), HttpStatus.OK);
	}

	/* Method to delete theater by ID */
	@RequestMapping(value = "/theater/{theaterId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTheater(@PathVariable("theaterId") Integer theaterId) {
		if (theaterId != 0) {
			return new ResponseEntity<String>(adminService.deleteTheater(theaterId), HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	
	/********************* Movie Add and Delete methods ***********************/

	/* Method to add new movie in theater by ID */
	@RequestMapping(value = "/movies/addMovie/{theaterId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addMovie(@RequestBody Movie movie, @PathVariable("theaterId") int theaterId) {
		Theater theater = adminService.findTheaterById(theaterId);
		if (theater != null) {
			moviesList = theater.getMovies();
			moviesList.add(movie);
			theater.setMovies(moviesList);
			return new ResponseEntity<String>(adminService.updateTheater(theater), HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND) ;
	}

	/* Method to delete movie by Id */
	@RequestMapping(value = "/movies/deleteMovie/{movieId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMovie(@PathVariable("movieId") Integer movieId) {
		return new ResponseEntity<String>(adminService.deleteMovie(movieId),HttpStatus.OK);
	}

	/******************************* Add and Delete Shows in the Screens ***********************/
	
	
	
	

	/* Method to delete show by Id */
	@RequestMapping(value = "/movies/deleteshow/{showId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteShow(@PathVariable("showId") Integer showId) {
		return new ResponseEntity<String>(adminService.deleteShow(showId), HttpStatus.OK);
	}
}
