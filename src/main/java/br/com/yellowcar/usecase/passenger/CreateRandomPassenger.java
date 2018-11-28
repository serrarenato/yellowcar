package br.com.yellowcar.usecase.passenger;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.PassengersWorld;
import br.com.yellowcar.usecase.observer.ObserverMobile;

/**
 * Create a passenger in some place of screen
 * 
 * @author renato
 *
 */
@Service
public final class CreateRandomPassenger {

	@Autowired
	ObserverMobile observer;

	public Passenger execute() {
		String generatedString = "pass-" + RandomStringUtils.randomNumeric(4);
		Passenger passenger = new Passenger(generatedString, observer);
		PassengersWorld.setPassengerInWorld(passenger);
		passenger.ready();
		return passenger;
	}
}
