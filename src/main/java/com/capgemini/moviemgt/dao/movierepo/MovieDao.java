/**
 * 
 */
package com.capgemini.moviemgt.dao.movierepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviemgt.model.Movie;

/**
 * @author krishna
 *
 */
@Repository
public interface MovieDao extends JpaRepository<Movie, Integer>{

	public List<Movie> findByMovieName(String movieName) ;
}
