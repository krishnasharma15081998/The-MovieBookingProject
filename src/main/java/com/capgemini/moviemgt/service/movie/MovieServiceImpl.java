/**
 * 
 */
package com.capgemini.moviemgt.service.movie;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moviemgt.dao.movierepo.MovieDao;
import com.capgemini.moviemgt.model.Movie;
/**
 * @author krishna
 *
 */

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDao dao ;
	
	@Override
	public List<Movie> getAllMovies(String movieName) {
		List<Movie> movies = dao.findAll() ;
		return movies;
	}
	
	@Override
	public List<Movie> searchMovie(String movieName) {
		return dao.findByMovieName(movieName) ;
	}

	@Override
	public Movie findMovieById(int movieId) {
		Optional<Movie> m = dao.findById(movieId) ;
		if(!m.isPresent()) {
			return null ;
		}
		return m.get() ;
	}

}
