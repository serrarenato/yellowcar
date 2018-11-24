package br.com.yellowcar.usecase.passenger;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;
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

	public Passenger execute(Integer sizeX, Integer sizeY) {
		String generatedString = "pass-" + RandomStringUtils.randomNumeric(4);
		Double x = Math.random() * sizeX;
		Double y = Math.random() * sizeY;
		Position2D position = new Position2D(x.intValue(), y.intValue());
		return new Passenger(generatedString,  observer);
	}
}
