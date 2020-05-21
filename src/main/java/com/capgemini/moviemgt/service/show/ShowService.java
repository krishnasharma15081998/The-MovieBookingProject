/**
 * 
 */
package com.capgemini.moviemgt.service.show;

import java.util.List;

import com.capgemini.moviemgt.model.Show;

/**
 * @author krishna
 *
 */
public interface ShowService {

	public List<Show> getAllShows(int theaterId) ;
	
}
