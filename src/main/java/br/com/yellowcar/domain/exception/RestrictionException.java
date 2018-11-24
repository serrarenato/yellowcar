package br.com.yellowcar.domain.exception;

public class RestrictionException extends Exception {
	public RestrictionException(){
		
	}
	public RestrictionException(String message){
		super(message);
	}
}
