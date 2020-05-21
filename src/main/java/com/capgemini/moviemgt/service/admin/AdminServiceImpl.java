/**
 * 
 */
package com.capgemini.moviemgt.service.admin;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moviemgt.dao.movierepo.MovieDao;

import com.capgemini.moviemgt.dao.showrepo.ShowDao;
import com.capgemini.moviemgt.dao.theaterrepo.TheaterRepository;
import com.capgemini.moviemgt.exception.EntityAlreadyPresentException;
import com.capgemini.moviemgt.exception.NoEntityFoundForGivenId;
import com.capgemini.moviemgt.model.Movie;

import com.capgemini.moviemgt.model.Show;
import com.capgemini.moviemgt.model.Theater;

/**
 * @author krishna
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private TheaterRepository dao ;
	
	@Autowired
	private MovieDao movieDao ;
	
	private ShowDao showDao ;
   
	/* Theater methods */
	
	@Override
	public Theater addTheater(Theater theater) {
		Optional<Theater> tId = dao.findById(theater.getTheaterId()) ;
		if(tId.isPresent()) {
			throw new EntityAlreadyPresentException("Already Present") ;
		}
		return dao.save(theater) ;	
	}

	@Override
	public String deleteTheater(int id) {
		Optional<Theater> theater = dao.findById(id) ;
		if(!theater.isPresent() || theater == null) {
			throw new NoEntityFoundForGivenId("No Theater Found By Given Id") ;
		}
		dao.deleteById(id);
		return "Theater Deleted Successfully!" ;
	}

	@Override
	public String updateTheater(Theater theater) {
		dao.save(theater) ;
		return "Theater Updated!" ;
	}

	@Override
	public Theater findTheaterById(int theaterId) {
		Optional<Theater> t = dao.findById(theaterId) ;
		if(!t.isPresent() || t == null) {
			throw new NoEntityFoundForGivenId("No Theater Found By Given Id") ;
		}
		Theater theater = t.get() ;
		return theater ;
	}
	
	/* Movie Methods */
	
	@Override
	public String deleteMovie(int id) {
		Optional<Movie> movie = movieDao.findById(id) ;
		if(!movie.isPresent()) {
			throw new NoEntityFoundForGivenId("Id Not found!") ;
		}
		dao.deleteById(id);
		return "Movie Deleted Successfully!";
	}
	
	/* Screen Methods */
	
	

	
	
	/* Show Methods */
	
	@Override
	public String deleteShow(int id) {
		Optional<Show> show = showDao.findById(id) ;
		if(!show.isPresent() || show == null) {
			throw new NoEntityFoundForGivenId("No Show Found for given ID!") ;
		}
		dao.deleteById(id);
		return "Show Deleted Successfully!";
	}

}
