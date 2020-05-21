/**
 * 
 */
package com.capgemini.moviemgt.service.theater;

import java.util.List;

import com.capgemini.moviemgt.model.Movie;
/**
 * @author krishna
 *
 */
public interface TheaterService {
	
	public List<Movie> getAllMovies(int theaterId) ;
	
	public Movie getMovie(String movieName, int TheaterId) ;
	
}
