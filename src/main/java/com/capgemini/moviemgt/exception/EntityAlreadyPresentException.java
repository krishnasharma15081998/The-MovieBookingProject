/**
 * 
 */
package com.capgemini.moviemgt.exception;

/**
 * @author krishna
 *
 */
@SuppressWarnings("serial")
public class EntityAlreadyPresentException extends RuntimeException{
	
	public EntityAlreadyPresentException(String message) {
		super(message) ;
	}

}
