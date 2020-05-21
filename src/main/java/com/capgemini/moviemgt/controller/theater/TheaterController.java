/**
 * 
 */
package com.capgemini.moviemgt.controller.theater;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviemgt.model.Movie;
import com.capgemini.moviemgt.service.theater.TheaterService;

/**
 * @author krishna
 *
 */
@RestController
@RequestMapping("/theater")
public class TheaterController {

	@Autowired
	private TheaterService service;
	
	@RequestMapping(value = "/{theaterId}/allMovies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> getAllMovies(@PathVariable("theaterId") int theaterId){
		return new ResponseEntity<List<Movie>>(service.getAllMovies(theaterId), HttpStatus.OK) ;
	}
	
	@RequestMapping(value = "/{theaterId}/{movieName}", method = RequestMethod.GET)
	public ResponseEntity<Movie> getMovie(@PathVariable("movieName") String movieName, @PathVariable("theaterId") int theaterId){
	 	return new ResponseEntity<Movie>(service.getMovie(movieName, theaterId), HttpStatus.OK) ;
	}
}
