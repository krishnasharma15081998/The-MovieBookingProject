/**
 * 
 */
package com.capgemini.moviemgt.exception;

/**
 * @author krishna
 *
 */
@SuppressWarnings("serial")
public class NoEntityFoundForGivenId extends RuntimeException{

	public NoEntityFoundForGivenId(String msg) {
		super(msg) ;
	}
}
