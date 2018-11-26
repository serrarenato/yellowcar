package br.com.yellowcar.domain.restriction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.exception.RestrictionException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.World;
import br.com.yellowcar.usecase.CalculateDistance;

@Service
public class MaxDistanceRestriction extends Restriction {
	@Autowired
	CalculateDistance calculateDistance;
	Double maxDistance;

	MaxDistanceRestriction() {
		this.maxDistance = calculateDistance.execute(new Position2D(0, 0),
				new Position2D(World.SIZE_X / 3, World.SIZE_Y / 3));
	}

	@Override
	public void isPossible(Cab cab, Passenger passenger) throws RestrictionException {
		double distance = calculateDistance.execute(cab.getLastPosition(), passenger.getInitialPosition());
		if (distance > maxDistance)
			throw new RestrictionException("Distancia Maxima");
		else if (this.getNext() != null)
			this.getNext().isPossible(cab, passenger);

	}

}
