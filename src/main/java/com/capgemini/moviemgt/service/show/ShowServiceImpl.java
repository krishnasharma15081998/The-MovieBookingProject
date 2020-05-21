/**
 * 
 */
package com.capgemini.moviemgt.service.show;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moviemgt.dao.showrepo.ShowDao;
import com.capgemini.moviemgt.exception.NullException;
import com.capgemini.moviemgt.model.Show;


/**
 * @author krishna
 *
 */
@Service
@Transactional
public class ShowServiceImpl implements ShowService{

	@Autowired
	private ShowDao showDao ;
	
	@Override
	public List<Show> getAllShows(int theaterId) {
		List<Show> shows = showDao.findByTheatersId(theaterId) ;
		if(shows.size() == 0) {
			throw new NullException("No Shows Available!") ;
		}
		return shows;
	}
}
