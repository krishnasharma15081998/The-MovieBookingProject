/**
 * 
 */
package com.capgemini.moviemgt.dao.theaterrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviemgt.model.Theater;

/**
 * @author krishna
 *
 */
@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer>{

	List<Theater> findByTheaterCity(String cityName) ;
		
}
