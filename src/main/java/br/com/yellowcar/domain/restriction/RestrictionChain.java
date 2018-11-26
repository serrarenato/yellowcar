package br.com.yellowcar.domain.restriction;

import org.springframework.beans.factory.annotation.Autowired;

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

	@Autowired
	MaxDistanceRestriction maxDistanceRestriction;

	@Autowired
	StateCabRestriction stateCabRestriction;

	public abstract boolean isPossible(Cab cab, Passenger passenger);
}
