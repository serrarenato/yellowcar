package br.com.yellowcar.usecase.passenger;

import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.exception.PassengerInvalidStateException;
import br.com.yellowcar.domain.mobile.Passenger;

/**
 * Put random position in a passenger
 * 
 * @author renato
 *
 */
@Service
public final class PutRandomPositionPassenger {

	public Passenger execute(Passenger passenger, Position2D world) throws PassengerInvalidStateException{
		if (!passenger.getState().equals(Passenger.State.INITIAL))
			throw new PassengerInvalidStateException("Estado invalido para inserir coordenadas");
		Double x = Math.random() * world.getX();
		Double y = Math.random() * world.getY();
		Position2D position = new Position2D(x.intValue(), y.intValue());
		passenger.setInitialPosition(position);
		x = Math.random() * world.getX();
		y = Math.random() * world.getY();
		position = new Position2D(x.intValue(), y.intValue());
		passenger.setDestination(position);
		passenger.next();
		return passenger;
	}
}
