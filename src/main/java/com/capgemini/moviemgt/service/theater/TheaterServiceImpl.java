/**
 * 
 */
package com.capgemini.moviemgt.service.theater;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional ;

import com.capgemini.moviemgt.dao.theaterrepo.TheaterRepository;
import com.capgemini.moviemgt.exception.NoEntityFoundForGivenId;
import com.capgemini.moviemgt.exception.NoMovieFound;
import com.capgemini.moviemgt.model.Movie;
import com.capgemini.moviemgt.model.Theater;

/**
 * @author krishna
 *
 */
@Service
@Transactional
public class TheaterServiceImpl implements TheaterService{
	
	@Autowired
	private TheaterRepository dao ;
	
	@Override
	public Movie getMovie(String movieName, int theaterId) {
		Optional<Theater> theater = dao.findById(theaterId) ;
		if(!theater.isPresent()) {
			throw new NoEntityFoundForGivenId("No theater Found!") ;
		}
		List<Movie> movies = theater.get().getMovies() ;
		for(Movie m : movies) {
			if(m.getMovieName().equals(movieName)) {
				return m ;
			}
		}
		throw new NoMovieFound("Oops " + movieName + "is not available!") ;
	}


	@Override
	public List<Movie> getAllMovies(int theaterId) {
		Optional<Theater> theater = dao.findById(theaterId);
		if(!theater.isPresent()) {
			throw new NoEntityFoundForGivenId("No theater Found for Given ID!") ;
		}
		return theater.get().getMovies() ;
	}
}
