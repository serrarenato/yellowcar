package br.com.yellowcar.usecase.passenger;

import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.exception.PassengerInvalidStateException;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.World;

/**
 * Put random position in a passenger
 * 
 * @author renato
 *
 */
@Service
public final class PutRandomPositionPassenger {

	public Passenger execute(Passenger passenger) throws PassengerInvalidStateException {
		if (!passenger.getState().equals(Passenger.State.INITIAL))
			throw new PassengerInvalidStateException("Estado invalido para inserir coordenadas");
		Double x = Math.random() * World.SIZE_X - 50;
		Double y = Math.random() * World.SIZE_Y - 50;
		Position2D position = new Position2D(x.intValue(), y.intValue());
		passenger.setDestination(position);

		x = Math.random() * World.SIZE_X - 50;
		y = Math.random() * World.SIZE_Y - 50;
		position = new Position2D(x.intValue(), y.intValue());
		passenger.next();
		passenger.setInitialPosition(position);

	
		return passenger;
	}
}
