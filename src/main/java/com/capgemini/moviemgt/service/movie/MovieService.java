/**
 * 
 */
package com.capgemini.moviemgt.service.movie;

import java.util.List;

import com.capgemini.moviemgt.model.Movie;
/**
 * @author krishna
 *
 */
public interface MovieService {
	
	public Movie findMovieById(int movieId) ;
	
	public List<Movie> getAllMovies(String movieName) ;

	public List<Movie> searchMovie(String movieName);
}
