/**
 * 
 */
package com.capgemini.moviemgt.controller.show;

import java.util.List;
/**
 * @author krishna
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviemgt.model.Show;
import com.capgemini.moviemgt.service.show.ShowService;


@RestController
@RequestMapping("/user")
public class ShowController {

	@Autowired
	private ShowService showService ;
	
	@RequestMapping(value = "/{theaterId}/allShows", method = RequestMethod.GET)
	public ResponseEntity<List<Show>> getAllShows(@PathVariable("theaterId") int id){
		return new ResponseEntity<List<Show>>(showService.getAllShows(id), HttpStatus.OK) ;
	}
}
