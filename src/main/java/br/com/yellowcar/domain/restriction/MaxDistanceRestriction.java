package br.com.yellowcar.domain.restriction;

import br.com.yellowcar.domain.exception.RestrictionException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.World;

public class MaxDistanceRestriction extends RestrictionChain{

	Integer maxDistance;
	@Override
	public void isPossible(Cab cab, Passenger passenger) throws RestrictionException {
		// TODO Auto-generated method stub
		
	}
	
}
