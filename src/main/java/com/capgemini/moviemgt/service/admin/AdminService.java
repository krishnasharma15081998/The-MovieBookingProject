/**
 * 
 */
package com.capgemini.moviemgt.service.admin;


import com.capgemini.moviemgt.model.Theater;

/**
 * @author krishna
 *
 */
public interface AdminService {

	/* Theater methods */

	public Theater addTheater(Theater theater);

	public String updateTheater(Theater theater);

	public String deleteTheater(int theaterId);

	public Theater findTheaterById(int theaterId);

	/* Movie Methods */

	public String deleteMovie(int id);

	/* Screen Methods */

	

	

	
	
	/* Show Methods */
	
	public String deleteShow(int id) ;
}
