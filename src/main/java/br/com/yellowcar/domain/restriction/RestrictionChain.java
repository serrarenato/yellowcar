package br.com.yellowcar.domain.restriction;

import br.com.yellowcar.domain.exception.RestrictionException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;

public enum RestrictionChain {

	STATECAB_MAXDISTANCE {

		@Override
		public boolean isPossible(Cab cab, Passenger passenger) {
			stateCabRestriction.setNext(maxDistanceRestriction);
			try {
				stateCabRestriction.isPossible(cab, passenger);
			} catch (RestrictionException e) {
				return false;
			}
			return true;
		}

	};

	MaxDistanceRestriction maxDistanceRestriction = new MaxDistanceRestriction();

	StateCabRestriction stateCabRestriction = new StateCabRestriction();

	public abstract boolean isPossible(Cab cab, Passenger passenger);
}
