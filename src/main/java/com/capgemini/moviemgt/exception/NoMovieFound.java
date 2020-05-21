/**
 * 
 */
package com.capgemini.moviemgt.exception;

/**
 * @author krishna
 *
 */
@SuppressWarnings("serial")
public class NoMovieFound extends RuntimeException{

	public NoMovieFound(String msg) {
		super(msg) ;
	}
}
