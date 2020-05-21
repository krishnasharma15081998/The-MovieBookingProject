/**
 * 
 */
package com.capgemini.moviemgt.dao.showrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviemgt.model.Show;

/**
 * @author krishna
 *
 */
@Repository
public interface ShowDao extends JpaRepository<Show, Integer>{

	List<Show> findByTheatersId(int theaterId) ;
}
