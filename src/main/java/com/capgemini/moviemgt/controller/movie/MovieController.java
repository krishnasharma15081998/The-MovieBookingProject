/**
 * 
 */
package com.capgemini.moviemgt.controller.movie;
/**
 * @author krishna
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviemgt.model.Movie;
import com.capgemini.moviemgt.service.movie.MovieService;
@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService service ;
	
	/* Method to search Movie by Name */
	@RequestMapping(value = "/searchMovie/{movieName}")
	public ResponseEntity<List<Movie>> searchMovieByName(@PathVariable("movieName") String movieName){
		return new ResponseEntity<List<Movie>>(service.getAllMovies(movieName), HttpStatus.OK) ;
	}
}
