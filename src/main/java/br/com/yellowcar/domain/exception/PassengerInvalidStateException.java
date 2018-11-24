package br.com.yellowcar.domain.exception;

public class PassengerInvalidStateException extends Exception {
	public PassengerInvalidStateException(){
		
	}
	public PassengerInvalidStateException(String message){
		super(message);
	}
}
