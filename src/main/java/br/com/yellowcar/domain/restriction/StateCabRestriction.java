package br.com.yellowcar.domain.restriction;

import br.com.yellowcar.domain.exception.RestrictionException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;

public class StateCabRestriction extends Restriction {

	@Override
	public void isPossible(Cab cab, Passenger passenger) throws RestrictionException {
		if (cab.getState()!=Cab.State.EMPTY)
			throw new RestrictionException("State cab Invalid");
		if (passenger.getState()!=Passenger.State.NO_CAB)
			throw new RestrictionException("State passenger Invalid");
		if (this.getNext() != null)
			this.getNext().isPossible(cab, passenger);
	}

}
